import Vue from 'vue'
import Vuex from 'vuex'
import authService from '../../service/common/CommonCall'

Vue.use(Vuex)


  const state = {
    isAuthenticated : false   /* can add other info to the state */
  }

  const getters = {
      isAuthenticated: (state, getters, rootState) =>{
        return state.isAuthenticated;
      }
    }

   const actions = {
     
    login({commit}, {username, password }) {      
      if (state.isAuthenticated ) {
          console.log('you are already logged in!')
      } else {
        
         return new Promise((resolve, reject) => {
              authService.login(username, password)
              .then(token => {
                      console.log('logged in user: token is ' + token);
                      commit('login', token);                      
                      resolve(token); 
                             
                      },                      
                  errors => {
                    console.log('error login');
                    reject(errors);
                 }
              )
              .catch( (err) =>
                console.log("Error to update state: " + err)
                )
              });
            }      
          } ,     
             


    logout({commit}) {
      return new Promise( (resolve, reject) => {
        authService.logoutStub()
        .then(response => {
                console.log('logged out ' + response);
                commit('logout', response);                      
                resolve(response); 
                       
                },                      
            errors => {
              console.log('error logout');
              reject(errors);
           }
        )
        .catch( (err) =>
          console.log("Error to update logout state: " + err)
          )
        }
      );
    }     
    
  }
    const mutations = {
      logout (state) {
        if(typeof window !== 'undefined') {
          window.localStorage.setItem('token', null);
          window.localStorage.setItem('tokenExpiration', null);
          sessionStorage.clear();
        }
        state.isAuthenticated = false;
        
      }, 
      login (state, token) {
        if (token === 'error') {
          state.isAuthenticated = false;
        } else {
          if(typeof window !== 'undefined') {
            window.localStorage.setItem('token', token);
            /*console.log("token expiration: " +  token.expiration)
            window.localStorage.setItem('tokenExpiration', token.expiration); */          
            sessionStorage.setItem('token', token);
            state.isAuthenticated = true;
          }       
       }
     } 
    } 

  export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
  }

  