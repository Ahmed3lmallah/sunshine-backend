<template>
  <div>
    <div class="card card-default">
      <div class="text-center" v-if="checkIfAdmin()">
          <button class="btn btn-primary text-center add-btn" @click="addUser">Add User</button>
      </div>
      <div class="card-body">
      <b-table responsive striped hover :items="activeUsers" :fields="userFields">
          <template slot="actions" scope="row">
            <span class="fa-stack edit-office" @click="editUser(row.item.username)" v-if="checkIfAdmin()">
              <i class="fas fa-edit fa-2x icon-button"></i>
              <span class="icon-tooltip fa-stack-1x font-weight-bold">Edit</span>
            </span>  
            &nbsp;&nbsp;            
            <span class="fa-stack edit-office" @click="deleteUser(row.item.username)" v-if="checkIfAdmin()">
              <i class="far fa-trash-alt fa-2x icon-button"></i>
              <span class="icon-tooltip fa-stack-1x font-weight-bold">Delete</span>
            </span>
            <span class="fa-stack edit-office" @click="viewUser(row.item.username)">
              <i class="fas fa-eye fa-2x icon-button"></i>
              <span class="icon-tooltip fa-stack-1x font-weight-bold">View User</span>
            </span>
          </template>
        </b-table>
      </div>
    </div>
    <div class="text-center" v-show="loading">Loading Users...</div>    
  </div>
</template>

<script>
import userService from "../../../service/common/UserDataService.js";
import authService from "../../../service/common/CommonCall";
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
          userList.push({
            username:m.username,
            firstName: m.firstName,
            lastName: m.lastName,
            role: m.role != null ? m.role.name : '',
            department: m.department,
            active: m.active
          })
        );
        this.users = userList.slice(4);
        this.loading = false;
      });
    },
    editUser(username) {
      this.$router.push({
        name: "editUser",
        params: {
          id: username
        }
      });
    },
    viewUser(username){
      alert("Work in progress")
    },
    deleteUser(username){
      Vue.dialog
        .confirm('Disable User?')
        .then(async (dialog) => {
          await userService.deleteUser(username);
          await this.getUsers();
          dialog.close && dialog.close()
      })
      .catch(function() {
        console.log('Clicked on cancel');
      });
    },
    checkIfAdmin() {
      return authService.checkAuthority("ROLE_ADMIN");
    }
  },
  watch: {
    "route": "getUsers"
  },
  computed: {
    activeUsers() {
      return this.users.filter(user => user.active);
    },
    inactiveUsers() {
      return this.users.filter(user => !user.active);
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
