module.exports = {
    presets: [
        ['@vue/app', {
            polyfills: [
                'es6.promise',
                'es6.symbol',
                'es7.object.entries', // vue2-google-map
                'es7.array.includes'  // vuebootstrap table
            ]
        }]
    ]
}