<template>
  <div>
    <!-- <NavBar /> -->

    <div class="container">

      <div class="text-center">
        <!--<div v-if="id">ID Found {{id}}</div>-->

        <!--<button v-if="checkIfAdmin()" class="btn btn-primary text-center add-btn" @click="addEquipment">Add equipment</button>-->
        <button class="btn btn-primary text-center add-btn" @click="addEquipment" v-if="checkIfAdmin()">Add equipment</button>
      </div>
      <!-- <equipment-table /> -->
      <allEquipmentList />
    </div>
  </div>

</template>

<script>
  import ContentWrapper from "../../components/Layout/ContentWrapper";
  //import equipmentListTableVue from "./equipmentListComponents/equipmentListTable.vue";
  import NavBar from "../../../src/components/NavBar/navbar.vue";
  import allEquipmentList from "./allEquipmentList";
  import authService from '../../service/common/CommonCall'
  export default {
    data() {
      return {
        id: this.$route.params.id
      };
    },
    components: {
      //"equipment-table": equipmentListTableVue,
      ContentWrapper: ContentWrapper,
      NavBar,
      allEquipmentList
    },
    methods: {
      // checkIfAdmin(){
      //   return authService.checkAuthority("ROLE_ADMIN");
      // },
      addEquipment() {
        this.$router.push({ name: "addEquipment" });
      },
      checkIfAdmin() {
        return authService.checkAuthority("ROLE_ADMIN");
      }
    },
    computed: {
      // userPermissions() {
      //   const token = sessionStorage.getItem("access_token")
      //   try {
      //     const parsed = JSON.parse(atob(token.split('.')[1]))
      //     return parsed.authorities;
      //   } catch (e) {
      //     return e;
      //   }
      // },
    },
  };
</script>

<style scoped>
  .add-btn {
    width: 50%;
  }
</style>
