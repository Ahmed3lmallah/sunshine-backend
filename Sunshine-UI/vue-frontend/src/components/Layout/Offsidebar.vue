<template>
    <aside class="offsidebar d-none">
        <b-tabs nav-class="nav-justified">
            <b-tab title="first" active>
                <template slot="title">
                    <em class="icon-equalizer fa-lg"></em>
                </template>
                <h3 class="text-center text-thin mt-4">Settings</h3>
                <div class="p-2">
                    <h4 class="text-muted text-thin">Themes</h4>
                    <div class="row row-flush mb-2">
                        <div class="col mb-2">
                            <div class="setting-color">
                                <label>
                                    <input type="radio" name="setting-theme" checked="checked" v-model="themePath" value="themes/theme-a.css">
                                    <span class="icon-check"></span>
                                    <span class="split">
                                        <span class="color bg-info"></span>
                                        <span class="color bg-info-light"></span>
                                    </span>
                                    <span class="color bg-white"></span>
                                </label>
                            </div>
                        </div>
                        <div class="col mb-2">
                            <div class="setting-color">
                                <label>
                                    <input type="radio" name="setting-theme" v-model="themePath" value="themes/theme-b.css">
                                    <span class="icon-check"></span>
                                    <span class="split">
                                        <span class="color bg-green"></span>
                                        <span class="color bg-green-light"></span>
                                    </span>
                                    <span class="color bg-white"></span>
                                </label>
                            </div>
                        </div>
                        <div class="col mb-2">
                            <div class="setting-color">
                                <label>
                                    <input type="radio" name="setting-theme" v-model="themePath" value="themes/theme-c.css">
                                    <span class="icon-check"></span>
                                    <span class="split">
                                        <span class="color bg-purple"></span>
                                        <span class="color bg-purple-light"></span>
                                    </span>
                                    <span class="color bg-white"></span>
                                </label>
                            </div>
                        </div>
                        <div class="col mb-2">
                            <div class="setting-color">
                                <label>
                                    <input type="radio" name="setting-theme" v-model="themePath" value="themes/theme-d.css">
                                    <span class="icon-check"></span>
                                    <span class="split">
                                        <span class="color bg-danger"></span>
                                        <span class="color bg-danger-light"></span>
                                    </span>
                                    <span class="color bg-white"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row row-flush mb-2">
                        <div class="col mb-2">
                            <div class="setting-color">
                                <label>
                                    <input type="radio" name="setting-theme" v-model="themePath" value="themes/theme-e.css">
                                    <span class="icon-check"></span>
                                    <span class="split">
                                        <span class="color bg-info-dark"></span>
                                        <span class="color bg-info"></span>
                                    </span>
                                    <span class="color bg-gray-dark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="col mb-2">
                            <div class="setting-color">
                                <label>
                                    <input type="radio" name="setting-theme" v-model="themePath" value="themes/theme-f.css">
                                    <span class="icon-check"></span>
                                    <span class="split">
                                        <span class="color bg-green-dark"></span>
                                        <span class="color bg-green"></span>
                                    </span>
                                    <span class="color bg-gray-dark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="col mb-2">
                            <div class="setting-color">
                                <label>
                                    <input type="radio" name="setting-theme" v-model="themePath" value="themes/theme-g.css">
                                    <span class="icon-check"></span>
                                    <span class="split">
                                        <span class="color bg-purple-dark"></span>
                                        <span class="color bg-purple"></span>
                                    </span>
                                    <span class="color bg-gray-dark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="col mb-2">
                            <div class="setting-color">
                                <label>
                                    <input type="radio" name="setting-theme" v-model="themePath" value="themes/theme-h.css">
                                    <span class="icon-check"></span>
                                    <span class="split">
                                        <span class="color bg-danger-dark"></span>
                                        <span class="color bg-danger"></span>
                                    </span>
                                    <span class="color bg-gray-dark"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="p-2">
                    <h4 class="text-muted text-thin">Layout</h4>
                    <div class="clearfix">
                        <p class="float-left">Fixed</p>
                        <div class="float-right">
                            <label class="switch">
                                <input type="checkbox" name="isFixed" v-model="isFixed">
                                <span></span>
                            </label>
                        </div>
                    </div>
                    <div class="clearfix">
                        <p class="float-left">Boxed</p>
                        <div class="float-right">
                            <label class="switch">
                                <input type="checkbox" name="isBoxed" v-model="isBoxed">
                                <span></span>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="p-2">
                    <h4 class="text-muted text-thin">Aside</h4>
                    <div class="clearfix">
                        <p class="float-left">Collapsed</p>
                        <div class="float-right">
                            <label class="switch">
                                <input type="checkbox" name="isCollapsed" v-model="isCollapsed">
                                <span></span>
                            </label>
                        </div>
                    </div>
                    <div class="clearfix">
                        <p class="float-left">Collapsed Text</p>
                        <div class="float-right">
                            <label class="switch">
                                <input type="checkbox" name="isCollapsedText" v-model="isCollapsedText">
                                <span></span>
                            </label>
                        </div>
                    </div>
                    <div class="clearfix">
                        <p class="float-left">Float</p>
                        <div class="float-right">
                            <label class="switch">
                                <input type="checkbox" name="isFloat" v-model="isFloat">
                                <span></span>
                            </label>
                        </div>
                    </div>
                    <div class="clearfix">
                        <p class="float-left">Hover</p>
                        <div class="float-right">
                            <label class="switch">
                                <input type="checkbox" name="asideHover" v-model="asideHover">
                                <span></span>
                            </label>
                        </div>
                    </div>
                    <div class="clearfix">
                        <p class="float-left">Show Scrollbar</p>
                        <div class="float-right">
                            <label class="switch">
                                <input type="checkbox" name="asideScrollbar" v-model="asideScrollbar">
                                <span></span>
                            </label>
                        </div>
                    </div>
                </div>
            </b-tab>
            <b-tab title="second" >
                <template slot="title">
                    <em class="icon-user fa-lg"></em>
                </template>
                <h3 class="text-center text-thin mt-4">Connections</h3>
                <div class="list-group">
                    <!-- START list title-->
                    <div class="list-group-item border-0">
                        <small class="text-muted">ONLINE</small>
                    </div>
                    <!-- END list title-->
                    <div class="list-group-item list-group-item-action border-0">
                        <div class="media">
                            <img class="align-self-center mr-3 rounded-circle thumb48" src="img/user/05.jpg" alt="Image">
                            <div class="media-body text-truncate">
                                <a href="#">
                                    <strong>Juan Sims</strong>
                                </a>
                                <br>
                                <small class="text-muted">Designeer</small>
                            </div>
                            <div class="ml-auto">
                                <span class="circle bg-success circle-lg"></span>
                            </div>
                        </div>
                    </div>
                    <div class="list-group-item list-group-item-action border-0">
                        <div class="media">
                            <img class="align-self-center mr-3 rounded-circle thumb48" src="img/user/06.jpg" alt="Image">
                            <div class="media-body text-truncate">
                                <a href="#">
                                    <strong>Maureen Jenkins</strong>
                                </a>
                                <br>
                                <small class="text-muted">Designeer</small>
                            </div>
                            <div class="ml-auto">
                                <span class="circle bg-success circle-lg"></span>
                            </div>
                        </div>
                    </div>
                    <div class="list-group-item list-group-item-action border-0">
                        <div class="media">
                            <img class="align-self-center mr-3 rounded-circle thumb48" src="img/user/07.jpg" alt="Image">
                            <div class="media-body text-truncate">
                                <a href="#">
                                    <strong>Billie Dunn</strong>
                                </a>
                                <br>
                                <small class="text-muted">Designeer</small>
                            </div>
                            <div class="ml-auto">
                                <span class="circle bg-danger circle-lg"></span>
                            </div>
                        </div>
                    </div>
                    <div class="list-group-item list-group-item-action border-0">
                        <div class="media">
                            <img class="align-self-center mr-3 rounded-circle thumb48" src="img/user/08.jpg" alt="Image">
                            <div class="media-body text-truncate">
                                <a href="#">
                                    <strong>Tomothy Roberts</strong>
                                </a>
                                <br>
                                <small class="text-muted">Designeer</small>
                            </div>
                            <div class="ml-auto">
                                <span class="circle bg-warning circle-lg"></span>
                            </div>
                        </div>
                    </div>
                    <!-- START list title-->
                    <div class="list-group-item border-0">
                        <small class="text-muted">OFFLINE</small>
                    </div>
                    <!-- END list title-->
                    <div class="list-group-item list-group-item-action border-0">
                        <div class="media">
                            <img class="align-self-center mr-3 rounded-circle thumb48" src="img/user/09.jpg" alt="Image">
                            <div class="media-body text-truncate">
                                <a href="#">
                                    <strong>Lawrence Robinson</strong>
                                </a>
                                <br>
                                <small class="text-muted">Designeer</small>
                            </div>
                            <div class="ml-auto">
                                <span class="circle bg-warning circle-lg"></span>
                            </div>
                        </div>
                    </div>
                    <div class="list-group-item list-group-item-action border-0">
                        <div class="media">
                            <img class="align-self-center mr-3 rounded-circle thumb48" src="img/user/10.jpg" alt="Image">
                            <div class="media-body text-truncate">
                                <a href="#">
                                    <strong>Tyrone Owens</strong>
                                </a>
                                <br>
                                <small class="text-muted">Designeer</small>
                            </div>
                            <div class="ml-auto">
                                <span class="circle bg-warning circle-lg"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="px-3 py-4 text-center">
                    <!-- Optional link to list more users-->
                    <a class="btn btn-purple btn-sm" href="#" title="See more contacts">
                        <strong>Load more..</strong>
                    </a>
                </div>
                <!-- Extra items-->
                <div class="px-3 py-2">
                    <p>
                        <small class="text-muted">Tasks completion</small>
                    </p>
                    <div class="progress progress-xs m-0">
                        <div class="progress-bar bg-success" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                            <span class="sr-only">80% Complete</span>
                        </div>
                    </div>
                </div>
                <div class="px-3 py-2">
                    <p>
                        <small class="text-muted">Upload quota</small>
                    </p>
                    <div class="progress progress-xs m-0">
                        <div class="progress-bar bg-warning" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                            <span class="sr-only">40% Complete</span>
                        </div>
                    </div>
                </div>
            </b-tab>

        </b-tabs>

    </aside>
</template>

<script>
    import { mapGetters, mapMutations } from 'vuex'

    export default {
        name: 'Offsidebar',
        computed: {
            isFixed: {
                get () { return this.getSetting.isFixed },
                set (value) { this.changeSetting({name: 'isFixed', value}) }
            },
            isBoxed: {
                get () { return this.getSetting.isBoxed },
                set (value) { this.changeSetting({name: 'isBoxed', value}) }
            },
            isCollapsed: {
                get () { return this.getSetting.isCollapsed },
                set (value) { this.changeSetting({name: 'isCollapsed', value}) }
            },
            isCollapsedText: {
                get () { return this.getSetting.isCollapsedText },
                set (value) { this.changeSetting({name: 'isCollapsedText', value}) }
            },
            isFloat: {
                get () { return this.getSetting.isFloat },
                set (value) { this.changeSetting({name: 'isFloat', value}) }
            },
            asideHover: {
                get () { return this.getSetting.asideHover },
                set (value) { this.changeSetting({name: 'asideHover', value}) }
            },
            asideScrollbar: {
                get () { return this.getSetting.asideScrollbar },
                set (value) { this.changeSetting({name: 'asideScrollbar', value}) }
            },
            themePath: {
                get () { return this.getTheme },
                set (value) { this.changeTheme(value) }
            },
            ...mapGetters([
                'getSetting',
                'getTheme'
            ])
        },
        methods: {
            ...mapMutations([
                'changeSetting',
                'changeTheme'
            ])
        },
        mounted() {
            // unhide offsidebar on mounted
            document.querySelector('.offsidebar.d-none').classList.remove('d-none')
        }
    }
</script>
