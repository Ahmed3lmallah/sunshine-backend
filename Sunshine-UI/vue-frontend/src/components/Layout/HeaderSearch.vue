<template>
    <!-- START Search form-->
    <form :class="{'navbar-form': true, 'open': this.isOpen}" role="search" action="search.html">
        <div class="form-group">
            <input ref="input" class="form-control" type="text" placeholder="Type and hit enter ...">
            <div class="fas fa-times navbar-form-close" v-on:click="onClose"></div>
        </div>
        <button class="d-none" type="submit">Submit</button>
    </form>
    <!-- END Search form-->
</template>

<script>

export default {
    name: 'HeaderSearch',
    props: {
        onClose: {
            type: Function,
            required: true
        },
        isOpen: {
            type: Boolean,
            required: true
        },
    },
    mounted() {
        document.addEventListener('keydown', this.closeNavSearchKey);
        document.addEventListener('click', this.closeNavSearchClick);
    },
    destroyed() {
        document.removeEventListener('keydown', this.closeNavSearchKey);
        document.removeEventListener('click', this.closeNavSearchClick);
    },
    watch: {
        isOpen(val) {
            const input = this.$refs.input;
            if (input) input[val ? 'focus' : 'blur']();
        }
    },
    methods: {
        closeNavSearchKey(e) {
            if (e.keyCode === 27) this.onClose(e);
        },
        closeNavSearchClick(e) {
            if(this.isOpen && (!(e.target).closest('.navbar-form, .nav-link')))
                this.onClose(e);
        }
    }
}

</script>