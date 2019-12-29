<template>
    <form name="loginForm">
        <img src="../../assets/logo.svg" style="max-width:220px;width:100%;padding: 0 50px 20px;box-sizing: unset;" alt="logo">
        <!--Username-->
        <div class="inputGroup inputGroup1">
            <label for="username">Username:</label>
            <input autofocus id="username" name="name" placeholder="Username"
                   type="number"
                   v-model="username">
        </div>
        <div class="alert alert-warning" role="alert" v-if="usernameError">
            {{usernameError}}
        </div>
        <!--Password-->
        <div class="inputGroup inputGroup2">
            <label for="password">Password:</label>
            <input id="password" name="pass" type="password" placeholder="Password"
                   v-model="password">
        </div>
        <div class="alert alert-warning" role="alert" v-if="passwordError">
            {{passwordError}}
        </div>
        <!--Button-->
        <div class="inputGroup inputGroup3">
            <button @click="submitForm">Submit</button>
        </div>
        <div class="alert alert-danger" v-if="loginError">
            <span class="closebtn" onclick="this.parentElement.style.display='none';" @click="loginError=false">&times;</span>
            <strong>Error!</strong> Login was not successful.
        </div>
        <div class="register">
            Not registered? <a @click="registerUser">Create an account</a>
        </div>
    </form>
</template>

<script>
    import { mapGetters } from 'vuex'  
    export default {
        data() {
            return{
                username: "",
                password: "",
                usernameError: undefined,
                passwordError: undefined,
                loginError: false,
                returnUrl: this.$route.params.returnUrl,
            };
        }, watch: {
            "username": "validateUsername",
            "password": "validatePassword"
        },
        created(){
            if (this.isAuthenticated) {
                this.$router.push({name: 'main'});
            }
        },
      
        computed: {
          ...mapGetters('login', ['isAuthenticated'])
        },
        methods: {
            login (uname, passwd) {
          console.log("calllllllled");
              this.$store.dispatch('login/login', {username: uname, password: passwd})
             .then(
               (response) => {
                console.log("Got login response " + response)
                // this.username = ''
                // this.password = '' 
                 if (response !== undefined && response !== 'error' && response !== null) {
                    if (this.returnUrl) {
                        this.$router.push(this.returnUrl.fullPath);
                    } else {
                        this.$router.push({name:'main'});
                    } }
                 else 
                   this.loginError = true;
               }
          )
          .catch(()=>{ 
            // this.username = ''
            // this.password = ''
            console.error("Got nothing from server." )
          })          
        
    },   
            
            submitForm(e){
                e.preventDefault();
                this.errors = [];
                this.validateUsername();
                this.validatePassword();
                if(!this.usernameError && !this.passwordError){
                    this.login(this.username, this.password);
                } else {
                    this.loginError = true;
                }
            },
            validateUsername(){
                this.usernameError = undefined;
                if(!this.username.length){
                    this.usernameError = "Enter Username.";
                } else if(this.username.length !== 6){
                    this.usernameError = "Not valid. Please enter 6-digit Cognizant id."
                }
            },
            validatePassword(){
                this.passwordError = undefined;
                if(!this.password.length){
                    this.passwordError = "Enter Password.";
                }
            },
            registerUser(){
                alert("Work in progress")
            }
        }
    };
</script>

<style scoped>
    form {
        position: absolute;
        top: 50%;
        left: 50%;
        -webkit-transform: translate(-50%, -50%);
        transform: translate(-50%, -50%);
        display: block;
        width: 100%;
        max-width: 400px;
        background-color: #FFF;
        margin: 0;
        padding: 2.25em;
        box-sizing: border-box;
        border: solid 1px #DDD;
        border-radius: .5em;
        font-family: 'Source Sans Pro', sans-serif;
    }
    form .inputGroup {
        margin: 0 0 1em;
        padding: 0;
        position: relative;
    }
    form .inputGroup:last-of-type {
        margin-bottom: 0;
    }
    form label {
        margin: 0 0 12px;
        display: block;
        font-size: 1.25em;
        color: #217093;
        font-weight: 700;
        font-family: inherit;
    }
    form input[type="number"], form input[type='password'] {
        display: block;
        margin: 0;
        padding: 0 1em 0;
        background-color: #f3fafd;
        border: solid 2px #217093;
        border-radius: 4px;
        -webkit-appearance: none;
        box-sizing: border-box;
        width: 100%;
        height: 65px;
        font-size: 1.25em;
        color: #353538;
        font-weight: 600;
        font-family: inherit;
        transition: box-shadow .2s linear, border-color .25s ease-out;
    }
    form input[type="number"]:focus, form input[type='password']:focus {
        outline: none;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        border: solid 2px #4eb8dd;
    }
    form input[type="number"] {
        padding: 14px 1em 0;
    }
    form button {
        display: block;
        margin: 0;
        padding: .65em 1em 1em;
        background-color: #4eb8dd;
        border: none;
        border-radius: 4px;
        box-sizing: border-box;
        box-shadow: none;
        width: 100%;
        height: 65px;
        font-size: 1.55em;
        color: #FFF;
        font-weight: 600;
        font-family: inherit;
        transition: background-color .2s ease-out;
    }
    form button:hover, form button:active {
        background-color: #217093;
    }
    .closebtn {
        margin-left: 15px;
        color: white;
        font-weight: bold;
        float: right;
        font-size: 22px;
        line-height: 20px;
        cursor: pointer;
        transition: 0.3s;
    }
    .closebtn:hover {
        color: black;
    }
    .register a {
        color: blue;
        text-decoration: underline;
    }
</style>
