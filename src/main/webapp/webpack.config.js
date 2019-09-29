const path = require('path');
const { VueLoaderPlugin } = require('vue-loader');
var webpack =require('webpack');

module.exports = {
	entry: path.join(__dirname, './main.js'),
	output: {
		path: path.join(__dirname, 'dist'),
		filename: 'bundle.js'
	},
	module: {
		rules: [
			{test: /\.css$/, use:['style-loader','css-loader']},
			{test: /\.(jpg|png|gif)$/, use:'url-loader?'},
			{test: /\.(ttf|eot|svg|woff|woff2)$/, use:'url-loader'},
			{test: /\.vue$/, use:'vue-loader'}
		]
	},
	resolve: {
		alias: {
			"vue$":"vue/dist/vue.js"
		}
	},
	plugins: [
		new VueLoaderPlugin(),
		new webpack.ProvidePlugin({
			$:"jquery",
			jQuery:"jquery",	
			"window.jQuery":"jquery"
		})
	]
};