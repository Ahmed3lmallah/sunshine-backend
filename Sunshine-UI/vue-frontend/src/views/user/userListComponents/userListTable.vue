<template>
  <div>
    <div class="card card-default">
      <div class="text-center">
          <button class="btn btn-primary text-center add-btn" @click="addUser">Add User</button>
      </div>
      <div class="card-body">
      <b-table responsive striped hover :items="users" :fields="userFields">
          <template slot="actions" scope="row">
            <span class="fa-stack edit-office" @click="editUser(row.item.username)">
              <i class="fas fa-edit fa-2x icon-button"></i>
              <span class="icon-tooltip fa-stack-1x font-weight-bold">Edit</span>
            </span>  
            &nbsp;&nbsp;            
            <span class="fa-stack edit-office" @click="deleteUser(row.item.username)">
              <i class="far fa-trash-alt fa-2x icon-button"></i>
              <span class="icon-tooltip fa-stack-1x font-weight-bold">Delete</span>
            </span>
          </template>
        </b-table>
      </div>
    </div>

<!--
    <table class="table table-hover table-dark mt-3">
      <thead>
        <tr>
          <th scope="col">Username</th>
          <th scope="col">First Name</th>
          <th scope="col">Last Name</th>
          <th scope="col">Role</th>
          <th scope="col">Department</th>
          <th scope="col"></th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in users" :key="user.Id" :user="user" @delete-user="setDelete">
          <th scope="row">{{user.username}}</th>
          <td>{{user.firstName}}</td>
          <td>{{user.lastName}}</td>
          <td>{{user.roles[0].name}}</td>
          <td>{{user.department}}</td>
          <td @click="editUser(user.username)" class="edit-user text-center">
            <i class="fas fa-pencil-alt"></i>
          </td>
          <td @click="deleteUser(user.username)" class="edit-user text-center">
            <i class="fas fa-trash"></i>
          </td>
        </tr>
        <tr
          class="inactive"
          v-for="user in inactiveUsers"
          :key="user.userId"
          :user="user"
          
        />
      </tbody>
    </table>
    -->
    <div class="text-center" v-show="loading">Loading Users...</div>    
  </div>
</template>

<script>
import userService from "../../../service/common/UserDataService.js";

import Vue from 'vue';
import VuejsDialog from 'vuejs-dialog';
import VuejsDialogMixin from 'vuejs-dialog/dist/vuejs-dialog-mixin.min.js'; // only needed in custom components
 
// include the default style
import 'vuejs-dialog/dist/vuejs-dialog.min.css';
 
// Tell Vue to install the plugin.
Vue.use(VuejsDialog,{
  html: true,
  loader: true,
  okText: 'Disable',
  cancelText: 'Cancel',
  animation: 'bounce'
});


export default {
  data() {
    return {
      users: [
      ],
      loading: false,
     // deleteUser: false,
      idToDelete: 1,      
      userFields: {
        username: {
          label: "User Name",
          sortable: true
        },
        firstName: {
          label: "First Name",
          sortable: true
        },
        lastName: {
          label: "Last NAme",
          sortable: true
        },
        role: {
          label: "Role",
          sortable: true          
        },
        department: {
          label: "Department",
          sortable: true
        },
        actions: {
          label: "Actions"
        }
      },
      
    };
  },
  created() {   
    this.getUsers();
  },
  props: {
    user: {
      type: Object,
      default: function() {
        return {};
      }
    }
  },
  methods: {
    addUser() {
      this.$router.push({path: "users/new"})
    },
    async getUsers() {
      this.loading = true;
      const promise = userService.getAllUsers();
      promise.then(result => {        
        var userList = [];
        result.map(m => 
          userList.push(
          {
            username:m.username,
            firstName: m.firstName,
            lastName: m.lastName,
            role: m.roles != null && m.roles.length > 0 ? m.roles[0].name.split("ROLE_")[1] : '',
            department: m.department
          }
          )
        );
        this.users = userList;
        this.loading = false;
      });
    },
    setDelete(id) {
      this.deleteUser = true;
      this.idToDelete = id;
    },
    clearDelete() {
      this.deleteUser = false;
    },
    editUser(id) {
      console.log(id)
      this.$router.push({
        name: "editUser",
        params: {
          id: id
        }
      });
    },
    async deleteUser(username){
      Vue.dialog
        .confirm('Disable User?')
        .then(function(dialog) {
        console.log('Clicked on proceed');
      })
      .catch(function() {
        console.log('Clicked on cancel');
      });


      // const promise = userService.deleteUser(this.username);
      // promise.then(res => {
      //   this.clearDelete();
      //   this.getUsers();
      // });
    },
    // async confirmDelete() {
    //   const promise = userService.deleteUser(this.idToDelete);
    //   promise.then(res => {
    //     this.clearDelete();
    //     this.getUsers();
    //   });
    // }
  },
  watch: {
    "route": "getUsers"
  },
  computed: {
    activeUsers() {
      let active = this.users.filter(user => user.active);
      return active;
    },
    inactiveUsers() {
      let inactive = this.users.filter(user => !user.active);
      return inactive;
    }
  }
};
</script>

<style>
.inactive {
  background-color: darkgray;
}
.edit-user:hover {
  cursor: pointer;
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
}

.edit-user {
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
}


.icon-tooltip {

    opacity: 0;
  }

  .edit-office:hover .icon-tooltip {
    opacity: 0.5;
  }

  .icon-button {
    opacity: 0.5;
  }

  .edit-office:hover .icon-button {
    opacity: 0;
  }

  .add-btn {
    width: 30%;
  }

</style>
