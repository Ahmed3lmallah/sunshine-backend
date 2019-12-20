<template>
    <div :style="style" />
</template>

<script>
import $ from 'jquery';
import deepEqual from 'deep-equal';

// Flot Charts
import 'flot/jquery.flot.js';
import 'flot/jquery.flot.categories.js';
import 'flot/jquery.flot.pie.js';
import 'flot/jquery.flot.resize.js';
import 'flot/jquery.flot.time.js';
import 'jquery.flot.spline/jquery.flot.spline.js';
import 'jquery.flot.tooltip/js/jquery.flot.tooltip.min.js';

/**
 * Wrapper component for jquery-flot plugin
 */
export default {
    name: 'FlotChart',
    props: {
        /** data to display */
        data: Array,
        /** flot options object */
        options: Object,
        /** height of the container element */
        height: {
            type: String,
            default: '300px'
        },
        /** width of the container element */
        width: {
            type: String,
            default: '100%'
        }
    },
    data() {
        return {
            chartData: this.data,
            chartOptions: this.options,
            style: {
                height: this.height,
                width: this.width
            }
        }
    },
    created() {
        if(typeof $.plot === 'undefined')
            throw new Error('Flot plugin not present.');
    },
    mounted() {
        this.drawChart();
    },
    destroyed() {
        $(this.$el).data('plot').shutdown();
    },
    watch: {
        chartData: {
            handler: 'drawChart',
            deep: true
        },
        chartOptions: {
            handler: 'drawChart',
            deep: true
        }
    },
    methods: {
        drawChart() {
            $.plot(this.$el, this.chartData, this.chartOptions);
        }
    }

}

</script>