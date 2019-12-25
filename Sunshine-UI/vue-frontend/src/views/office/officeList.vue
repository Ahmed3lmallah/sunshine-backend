<template>
  <div>
    <!-- <NavBar /> -->

    <div class="container">
      <div class="text-center">
        <button v-if="checkIfAdmin()" class="btn btn-primary text-center add-btn" @click="addOffice">Add Office</button>
      </div>
      <!-- <office-table /> -->
      <newOfficeList />
    </div>
  </div>
</template>

<script>
import ContentWrapper from "../../components/Layout/ContentWrapper";
import officeListTableVue from "./officeListComponents/officeListTable.vue";
import NavBar from "../../../src/components/NavBar/navbar.vue";
import newOfficeList from "./newOfficeList";
import authService from '../../service/common/CommonCall'

export default {
  components: {
    "office-table": officeListTableVue,
    ContentWrapper: ContentWrapper,
    NavBar,
    newOfficeList
  },
  methods: {
    checkIfAdmin(){
      return authService.checkAuthority("ROLE_ADMIN");
    },
    addOffice() {
      this.$router.push({ name: "addOffice" });
    }
  },
  computed: {
    userPermissions() {
      const token = sessionStorage.getItem("access_token")

      try {
        const parsed = JSON.parse(atob(token.split('.')[1]))
        return parsed.authorities;
      } catch (e) {
        return e;
      }
    },
  },
};
</script>

<style scoped>
.add-btn {
  width: 50%;
}
</style>