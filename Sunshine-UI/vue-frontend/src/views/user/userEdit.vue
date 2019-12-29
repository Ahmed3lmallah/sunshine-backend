<template>
    <div class="container">
      <div class="content-heading text-center">
        <h1 v-if="!id">Add User</h1>
        <h1 v-if="id">Update User</h1>
      </div>
      <form class="jumbotron jumbotron-fluid">
          <div v-if="errors.length">
          <div class="alert alert-warning" v-bind:key="index" v-for="(error, index) in errors">{{error}}</div>
        </div>
        <div class="form-group">
          <button v-on:click="redirect" type="button" class="close text-danger" aria-label="Close">
            <span aria-hidden="true">
              <i class="far fa-times-circle"></i>
            </span>
          </button>
        </div>
        <div class="form-group">
          <label for="username" >Username</label>
          <input type="text" class="form-control" id="username" v-model="user.username"/>
        </div>
        <div class="form-group" v-if="!this.id">
          <label for="password">Password</label>
          <input type="text" class="form-control" id="password" v-model="user.password"/>
        </div>
        <div class="form-group">
          <label for="firstName">First Name</label>
          <input type="text" class="form-control" id="firstName" v-model="user.firstName" />
        </div>
        <div class="form-group">
          <label for="lastName">Last Name</label>
          <input type="text" class="form-control" id="lastName" v-model="user.lastName"/>
        </div>        
        <div class="form-row">
        </div>
        <div class="form-group">
          <label for="email">Email</label>
          <input type="text" class="form-control" id="email" v-model="user.email"/>
        </div>
        <div class="form-group">

        </div>


        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="department">Department</label>
            <input type="text" class="form-control" id="department" v-model="user.department"/>
          </div>
          <div class="form-group col-md-2">
            <label for="managerId">Manager ID</label>
            <input type="number" class="form-control" id="managerId" v-model="user.managerId"/>
          </div>
          <div class="form-group col-md-4">
            <label for="role">Role</label>
            <select class="custom-select" id="role"  v-model="roleId" >
              <option value="1">Developer</option>
              <option value="2">Manager</option>
              <option value="3">Admin</option>
            </select>
          </div>
        </div>


        <div class="form-group">

        </div>
        <div class="form-group text-center">
          <button @click="validateAndSubmit" class="btn btn-lg btn-primary">Save</button>
          <button @click="cancelForm" class="btn btn-lg btn-danger ml-2">Cancel</button>
        </div>
      </form>
    </div>
</template>

<script>
import userDataService from "../../service/common/UserDataService";
export default {
  name: "user",
  data() {
    return {
      roleId: undefined,
      user: {
        username: '',
        password: '',
        firstName: '',
        lastName: '',
        managerId: '',
        email: '',
        department: '',
        role: '',
        active: true
      },
      id: this.$route.params.id,
      errors: []
    };
  },
  watch: {
    roleId: function() {
      switch (this.roleId) {
        case '1':
          this.user.role = {
            "id": 3,
            "name": "DEVELOPER"
          };
          break;
        case '2':
          this.user.role = {
            "id": 2,
            "name": "MANAGER"
          };
          break;
        case '3':
          this.user.role = {
            "id": 1,
            "name": "ADMIN"
          };
          break;
      }
    }
  },
  created() {
    if(this.id){
      userDataService.getUserByUsername(this.id).then(result => {
        this.user = result;
      });
    }
  },
  methods: {
      cancelForm: function(event){
        event.preventDefault();
        this.$router.push({name: "users"});
      },

      redirect: function (event) {
       this.$router.push({name: "users"});
      },
    //this code checks the validity of the fields

    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
      if (!this.user.firstName) {
        this.errors.push("Enter a first name");
      }
      if (!this.user.lastName) {
        this.errors.push("Enter a last name");
      }      
      if(!this.user.department){
        this.errors.push("Enter a department");
      }
      if(!this.user.username){
        this.errors.push("Enter a username");
      }

      //When the user input is valid, if there is no id in the path
      //then the user is saved to the database and the app is routed to officeList
      if (this.errors.length === 0) {
        if (!this.id) {
          userDataService.createUser(this.user).then(() => {
            this.$router.push({name: "users"});
          });
        }

        //When the user input is valid, if there is id in the path
        //then the office is updated in the database and the app is routed to officeList
        else {
          userDataService.updateUser(this.id, this.user).then(() => {
            this.$router.push({name: "users"});
          });
        }
      }
    }
  }
};
</script>
