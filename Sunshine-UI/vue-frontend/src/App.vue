<template>
    <div>
        <header v-show="this.$router.history.current.path!=='/login'">
            <navbar />  
        </header>

        <router-view/> 
    </div>
</template>

<script>
    import store from './store/index.js'
    import navbar from './components/NavBar/navbar'
    export default {
        name: 'App',
        store,
        components: {
            navbar
        }
    }
</script>

<style lang="scss">
  @import url('https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap');

  // Import Main styles for this application
  @import '@/styles/bootstrap.scss';
  @import '@/styles/app.scss';
</style>