<template>
  <div>
    <!-- <NavBar /> -->

    <div class="container">
      <div class="text-center">
        <button class="btn btn-primary text-center add-btn" @click="addEquipment">Add equipment</button>
      </div>

      <label for="officeName" id="officeDetails">Office: {{office.officeId}} - {{office.officeName}}</label>

      <div class="form-group">
        <input type="hidden" class="form-control" id="officeId" v-model="office.officeId" />
      </div>

      <equipment-table />


    </div>

  </div>
</template>
<script>
  import ContentWrapper from "../../components/Layout/ContentWrapper";
  import equipmentListTableVue from "./equipmentListComponents/equipmentListTable.vue";
  import NavBar from "../../../src/components/NavBar/navbar.vue";
  import OfficeDataService from "../../service/common/OfficeDataService";
  import equipmentService from "../../service/common/EquipmentDataService.js";
  export default {
    components: {
      "equipment-table": equipmentListTableVue,
      ContentWrapper: ContentWrapper,
      NavBar
    },
    methods: {
      addEquipment() {
        //this.$router.push({name: "addEquipment"})
        this.$router.push({
          name: "addEquipment",
          params: {
            officeId: this.office.officeId
          }})
      }
    },
    name: "office",
    data() {
      return {
        office: {
          officeName: '',
          streetAddress: '',
          city: '',
          zip: '',
          active: true
        },
        id:this.$route.params.id,
        errors: []
      };
    },
    created() {
      if(this.id){
        //OfficeDataService.getOfficeById(this.id).then( result
        equipmentService.getEquipmentsByOfficeId(this.id).then( result => {
          this.office = result;
          console.log(result);
        });
      }
    }
  };
</script>

<style scoped>
  .add-btn {
    width: 50%;
  }
  #officeDetails{
    font-family: Arial, Helvetica, sans-serif;
    font-size: 14pt;
    border: 1px;
    /*background-color:darkgray;*/
    text-align: left;
    color:darkolivegreen;
  }
</style>
