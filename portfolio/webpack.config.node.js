const path = require('path');
const nodeExternals = require('webpack-node-externals');

module.exports = {
  target: "node",
  entry: {
    app: ["./server/server.js"]
  },
  node: {
    global: false,
    __filename: false,
    __dirname: false,
  },
  output: {
    path: path.resolve(__dirname, "server"),
    filename: "bundle.server.js"
  },
  externals: [nodeExternals()],
};