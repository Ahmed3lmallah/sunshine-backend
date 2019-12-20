<!-- SLIMSCROLL
----------------------------------- -->

<template>
    <div v-bind="$props">
        <slot></slot>
    </div>
</template>

<script>
    import $ from 'jquery';
    // Slimscroll
    import 'jquery-slimscroll';

    /**
     * Wrapper for jquery-slimscroll plugin
     */
    export default {
        name: 'Scrollable',
        props: {
            /** height of the element */
            height: {
                type: Number,
                defaut: 250
            }
        },
        mounted() {
            $(this.$el).slimScroll({
                height: this.height
            });
        }
    }
</script>