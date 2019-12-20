<!-- SPARKLINE
----------------------------------- -->

<template>
    <component :is="tag" v-bind="$props"></component>
</template>

<script>
import $ from 'jquery';
// Sparklines
import 'jquery-sparkline/jquery.sparkline.min.js';

const RESIZE_EVENT = 'resize.sparkline';

/**
 * Wrapper for for jquery-sparkline plugin
 */
export default {
    name: 'Sparkline',
    props: {
        /** sparkline options object */
        options: Object,
        /** tag to use, defaults to div */
        tag: {
            type: String,
            default: 'DIV'
        },
        /** values to display, allows array or csv string */
        values: [ String, Array ]
    },
    data() {
        return {
            dataOptions: this.options,
            dataValues: this.values
        }
    },
    watch: {
        values() {
            $(this.$el).sparkline(this.values, this.dataOptions);
        }
    },
    mounted() {
        this.normalizeParams();

        // init sparkline
        $(this.$el).sparkline(this.values, this.dataOptions);

        // allow responsive
        if (this.dataOptions.resize) {
            $(window).on(RESIZE_EVENT, () => {
                $(this.$el).sparkline(this.values, this.dataOptions);
            });
        }
    },
    destroyed() {
        $(window).off(RESIZE_EVENT);
        $(this.$el).sparkline('destroy');
    },
    methods: {
        normalizeParams() {
            let { options, values } = this;

            options.disableHiddenCheck = true; // allow draw when initially is not visible
            options.type = options.type || 'bar'; // default chart is bar
            values = Array.isArray(values) ? values : values.split(','); // support array of csv strings

            this.dataOptions = options;
            this.dataValues = values;
        }
    }
}
</script>