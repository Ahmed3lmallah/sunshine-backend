import Vue from 'vue'
import Router from 'vue-router'

// Layouts
//import Layout from '@/components/Layout/Layout'
//import LayoutHorizontal from '@/components/Layout/LayoutHorizontal'
//import LayoutPage from '@/components/Layout/LayoutPage'

const maingView = () => import ('@/views/landing/main.vue')
const loginView = () => import ('@/views/login/login.vue')
const officeListView = () => import ('@/views/office/officeList.vue')
const officeEditView = () => import ('@/views/office/officeEdit.vue')

Vue.use(Router)

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            redirect: '/login',
        },
        {
            path: '/login',          
            component: loginView,
        },
        {
            path: '/main',
            component: maingView
        },
        {
            path: '/officeList',
            component: officeListView
        },
        {
            path: '/officeEdit',
            component: officeEditView
        },        
        {
            path: '*',
            redirect: '/'
        }
    ]
})
