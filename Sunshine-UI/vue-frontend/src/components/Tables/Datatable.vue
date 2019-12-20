<template>
    <table v-bind="$props" ref="tableElement">
        <slot></slot>
    </table>
</template>
<script>

    import $ from 'jquery';
    // Libraries for buttons
    import * as JSZip from "jszip";
    window.JSZip = JSZip;
    require('pdfmake/build/pdfmake.js');
    require('pdfmake/build/vfs_fonts.js');
    // Datatables
    require('datatables.net-bs')
    require('datatables.net-bs4/js/dataTables.bootstrap4.js')
    require('datatables.net-bs4/css/dataTables.bootstrap4.css')
    require('datatables.net-buttons')
    require('datatables.net-buttons-bs')
    require('datatables.net-responsive')
    require('datatables.net-responsive-bs')
    require('datatables.net-responsive-bs/css/responsive.bootstrap.css')
    require('datatables.net-buttons/js/buttons.colVis.js') // Column visibility
    require('datatables.net-buttons/js/buttons.html5.js') // HTML 5 file export
    require('datatables.net-buttons/js/buttons.flash.js') // Flash file export
    require('datatables.net-buttons/js/buttons.print.js') // Print view button
    require('datatables.net-keytable');
    require('datatables.net-keytable-bs/css/keyTable.bootstrap.css')

    /**
     * Wrapper component for dataTable plugin
     * Only DOM child elements, componets are not supported (e.g. <Table>)
     */
    export default {
        name: 'Datatable',
        props: {
            /** datatables options object */
            options: {
                type: Object,
                default: {}
            },
            /** callback that receives the datatable instance as param */
            dtInstance: Function
        },

        mounted() {
            const dtInstance = $(this.$refs.tableElement).dataTable(this.options);

            if(this.dtInstance)
                this.dtInstance(dtInstance)
        },

        destroyed() {
            $(this.$refs.tableElement).dataTable({destroy: true});
        }

    }

</script>