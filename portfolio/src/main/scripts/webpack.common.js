const path = require("path");
const webpack = require("webpack");
const CopyWebpackPlugin = require("copy-webpack-plugin");
const CleanWebpackPlugin = require("clean-webpack-plugin");
const HtmlWebpackPlugin = require("html-webpack-plugin");

var ASSET_PATH = "/static/";
console.log(path.resolve(__dirname, "/.."));

module.exports = {
  entry: {
    main: "./index.js",
  },
  output: {
    path: path.resolve(__dirname + "/../webapp", "static"),
    publicPath: "/" // necessary to get the CDN working correctly. publicPath (__webpack_public_path___) is overwritten at start of s&a to point to CDN.
  },
  resolve: {
    modules: [
      "../node_modules",
      path.resolve("./scripts"),
      path.resolve("."),
      "./css"
    ],
    extensions: [".wasm", ".mjs", ".js", ".json", ".jsx", ".tsx", ".ts"]
  },
  module: {
    rules: [
      {
        test: path.resolve(__dirname, "css/sa.custom.styles.less"),
        use: [
          {
            loader: "raw-loader"
          }
        ]
      },
      {
        test: require.resolve("jquery"), // jquery should be a global for s&a
        use: [
          {
            loader: "expose-loader",
            options: "jQuery"
          },
          {
            loader: "expose-loader",
            options: "jquery"
          },
          {
            loader: "expose-loader",
            options: "$"
          }
        ]
      },
      {
        test: require.resolve("underscore"),
        use: [
          {
            loader: "expose-loader",
            options: "_"
          }
        ]
      },
      {
        test: /i18next.js/,
        use: [
          {
            loader: "expose-loader",
            options: "i18n"
          }
        ]
      },

      {
        test: /\.(js|ts)x?$/,
        exclude: {
          or: [path.resolve(__dirname, "dist"), /node_modules\\(?!@esko)/, /@esko\\3d-web-viewer\\libs/]
        },
        use: [
          {
            loader: "babel-loader",
            options: {
              presets: ["@babel/preset-typescript", "@babel/preset-env", "@babel/preset-react"],
              plugins: [
                "@babel/plugin-proposal-class-properties",
              ]
            }
          }
        ]
      },
      {
        test: /\.(png|PNG|jpg|JPG|gif|GIF|svg|SVG|cur|ico)$/,
        use: [
          {
            loader: "file-loader",
            options: {}
          }
        ]
      },
      {
        test: /\.(woff|woff2|eot|ttf|otf)(\?cl=0)?$/,
        loader: "file-loader"
      },
      {
        test: /\.html$/,
        exclude: path.resolve(__dirname, "scripts"),
        use: [
          {
            loader: "tpl-loader",
            options: {
              variable: "d"
            }
          }
        ]
      },
      {
        test: /\.html$/,
        include: path.resolve(__dirname, "scripts"),
        use: [
          {
            loader: "tpl-loader"
          }
        ]
      },

      {
        test: /\.xml$/,
        use: [
          {
            loader: "raw-loader"
          }
        ]
      }
    ]
  },
  plugins: [
    new webpack.IgnorePlugin(
      /^\.\/locale$/,
      /moment/,
      /\.eot$/,
      /\.ttf$/,
      /\.otf$/
    ), // Exclude moment locales in bundles (load explicitly in js file),
   
    new webpack.DefinePlugin({
      "process.env.ASSET_PATH": JSON.stringify(ASSET_PATH)
    }),
    new webpack.DefinePlugin({
      "process.env.locale": "en"
    }),
    new CleanWebpackPlugin(
      [
        "static",
        "_sourcemaps"
      ],
      {
        root: path.resolve(__dirname + "/../", "webapp")
      }
    ),
    new webpack.IgnorePlugin(/^\.\/locale$/, /moment/)
  ]
};
