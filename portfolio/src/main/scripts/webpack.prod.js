const path = require("path");
const webpack = require("webpack");

var ASSET_PATH = "/static/";

module.exports = {
  entry: {
    main: "index.js",
  },
  output: {
    path: path.resolve(__dirname, "dist"),
    publicPath: "/" // necessary to get the CDN working correctly. publicPath (__webpack_public_path___) is overwritten at start of s&a to point to CDN.
  },
  mode: 'development',
  resolve: {
    modules: [
      "../node_modules",
      path.resolve("./src"),
      path.resolve(".")
    ],
    extensions: [".wasm", ".mjs", ".js", ".json", ".jsx", ".tsx", ".ts",".css"]
  },
  module: {
    rules: [
      {
        test: /\.(js|ts)x?$/,
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
    new HtmlWebpackPlugin()
  ]
};
