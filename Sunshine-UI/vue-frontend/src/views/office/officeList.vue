<template>
  <div>
    <!-- <NavBar /> -->
    
      <div class="container">
        <div class="text-center">
          <button class="btn btn-primary text-center add-btn" @click="addOffice">Add Office</button>
        </div>
        <office-table />


      </div>
    
  </div>
</template>

<script>
import ContentWrapper from "../../components/Layout/ContentWrapper";
import officeListTableVue from "./officeListComponents/officeListTable.vue";
import NavBar from "../../../src/components/NavBar/navbar.vue";

export default {
  components: {
    "office-table": officeListTableVue,
    ContentWrapper: ContentWrapper,
    NavBar
  },
  methods: {
    addOffice() {
      this.$router.push({path: "officeEdit"})
    }
  }
};
</script>

<style scoped>
  .add-btn {
    width: 50%;
  }
</style>