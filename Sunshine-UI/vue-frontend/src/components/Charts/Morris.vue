<template>
    <div :id="id"></div>
</template>

<script>
    // Raphael
    window.Raphael = require('raphael');
    // Morris.js
    import 'morris.js.so/morris.css';
    import 'morris.js.so/morris.js';

    /**
     * Wrapper for morris chart plugin
     */
    export default {
        name: 'Morris',
        props: {
            /** id of the container element */
            id: {
                type: String,
                required: true
            },
            /** data to display */
            data: {
                type: Array,
                required: true
            },
            /** morris option object */
            options: {
                type: Object,
                required: true
            },
            /** chart type */
            type: {
                type: String,
                validator: value => (['Line', 'Area', 'Donut', 'Bar'].indexOf(value) !== -1),
                required: true
            }
        },
        mounted() {
            this.drawChart();
        },
        methods: {
            drawChart() {
                const element = { element: this.id };
                const data = { data: this.data };
                this.chart = new Morris[this.type]({
                    ...element,
                    ...data,
                    ...this.options
                })
            }
        }
    }

</script>