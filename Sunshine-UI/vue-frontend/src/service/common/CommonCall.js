import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios);

const authService = {

    login: async (username, password) => {

        const authServiceUrl = "https://sunshine-auth-service.cfapps.io/oauth/token";
        const headerOptions = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'Authorization': 'Basic ' + btoa( 'ClientId:ClientSecret')
            }
        };
        const content = 'grant_type=password&username=' + username + '&password=' + password;

        return await axios.post(authServiceUrl, content, headerOptions)
            .then( response => {
                const token = response.data.access_token;
                sessionStorage.setItem('access_token', token);
                return token;
            }).catch( error => {
                console.log("ERROR: ", error);
                return null;
            });
    },

    getToken: () => {
        try {
            const accessToken = sessionStorage.getItem('access_token');
            return JSON.parse(atob(accessToken.split('.')[1]));
        } catch (e) {
            return false;
        }
    },

    checkAuthority: (role) => {
        const token = authService.getToken();
        try {
            return token.authorities.includes(role);
        } catch (e) {
            return false;
        }
    },

    logoutStub: async () => {
        console.log('logoutStub');
        return 'logged out';
    }
};

export default authService;
