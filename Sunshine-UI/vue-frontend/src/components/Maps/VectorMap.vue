<template>
    <div ref="mapElement" :style="{height: height}"></div>
</template>

<script>
    import $ from 'jquery';
    // jquery Vector Map
    import 'ika.jvectormap/jquery-jvectormap-1.2.2.min.js';
    import 'ika.jvectormap/jquery-jvectormap-world-mill-en.js';
    import 'ika.jvectormap/jquery-jvectormap-us-mill-en.js';
    import 'ika.jvectormap/jquery-jvectormap-1.2.2.css';

    /** Wrapper component for jquery-vectormap plugin */
    export default {
        name: 'VectorMap',
        props: {
            /** series entry of options object */
            series: Object,
            /** markers entry of options object */
            markers: Array,
            /** jvectormap options object */
            options: Object,
            /** height of the container element */
            height: {
                type: String,
                default: '300px'
            }
        },

        mounted() {
            this.options.markers = this.markers;
            this.options.series = this.series;
            $(this.$refs.mapElement).vectorMap(this.options);
        },

        beforeDestroy() {
            const map = $(this.$refs.mapElement).vectorMap('get', 'mapObject');
            map.remove()
        }
    }

</script>
