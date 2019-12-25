import '@fortawesome/fontawesome-free/css/all.min.css'
import 'bootstrap-css-only/css/bootstrap.min.css'
import 'mdbvue/lib/css/mdb.min.css'
/*!
 *
 * Angle - Bootstrap Admin Template
 *
 * Version: 4.6
 * Author: @themicon_co
 * Website: http://themicon.co
 * License: https://wrapbootstrap.com/help/licenses
 *
 */

import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue'
import VueI18Next from '@panter/vue-i18next';
import vueCountryRegionSelect from 'vue-country-region-select'

import './vendor.js'

import App from './App.vue'
import router from './router'
import i18next from './i18n.js';
import * as VueGoogleMaps from "vue2-google-maps";
import Geocoder from "@pderas/vue2-geocoder";
import authService from './service/common/CommonCall'
//import axios from 'axios'
//import VueAxios from 'vue-axios'


 

Vue.config.productionTip = false

Vue.use(BootstrapVue);
Vue.use(VueI18Next);
Vue.use(vueCountryRegionSelect)
//Vue.use(VueAxios, axios);


const i18n = new VueI18Next(i18next);

//const token = authService.getCall();
/*
To get token, send [POST] requests to https://sunshine-auth-service.cfapps.io/oauth/token with:

Basic Auth:
username: ClientId
password: ClientSecret

in Body (form-data):
username: admin
password: admin
grant_type: password
  
 */
Vue.use(Geocoder, {
  defaultCountryCode: null, // e.g. 'CA'
  defaultLanguage:    null, // e.g. 'en'
  defaultMode:        'address', // or 'lat-lng'
  googleMapsApiKey:   "AIzaSyDn5REd-ifbdS-DtVviYTCaIuGEKVhMdeA"
});

Vue.use(VueGoogleMaps, {
  load: {
    key: "AIzaSyDn5REd-ifbdS-DtVviYTCaIuGEKVhMdeA",
    libraries: "places" // necessary for places input
  }
});

new Vue({
  i18n,
    router,
    render: h => h(App)
}).$mount('#app')
