const postcss = require('postcss');
const rtlcss = require('rtlcss');

const rtlcssPlugin = postcss.plugin('rtlcssPlugin', options => css => rtlcss.process(css))

module.exports = rtlcssPlugin;
