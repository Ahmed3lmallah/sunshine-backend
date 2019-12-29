<template>
    <div class="container">
      <div class="content-heading text-center">
        <h1 v-if="!id">Add Equipment</h1>
        <h1 v-if="id">Update Equipment</h1>
      </div>
      <form class="jumbotron jumbotron-fluid">
          <!-- <div v-if="errors.length">
            <div class="alert alert-warning" v-bind:key="index" v-for="(error, index) in errors">{{error}}</div>
          </div> -->
        <!---  
        <div class="form-group">
          <button v-on:click="       redirect" type="button" class=" close     text-danger" aria-label="Close">
            <span aria-hidden="true">
              <i class="far fa-times-circle"></i>
            </span>
          </button>
        </div>
        --->
        <div class="form-row">
          <div class="form-group col-md-6">
             <div class="form-group">

              <!-- <div v-if="officeId">
                <label for="officeName" id="officeDetails">Office: {{office.officeId}} - {{office.officeName}}</label>
                <input type="hidden" class="form-control" id="officeId" v-model="office.officeId" />
              </div> -->
            
              <!-- <div v-if="!officeId">
                  <label for="officeName" id="officeDetails">Select Office: </label>
                  <select class="" style="width: 40%" name="officeId" id="officeId">
                    <option v-for="officeRow in office" v-bind:key="officeRow.officeId">
                        {{ officeRow.officeName }}
                    </option>
                  </select>
              </div>       -->
            </div>
          </div>
        </div>    

        
        <equipment-edit-form/>

         
        <!--- UserId text box, Comment Text box --> 

      </form>
    </div>
</template>

<script>
import OfficeDataService from "../../service/common/OfficeDataService";
import equipmentEditFormVue from "./equipmentEditForm.vue";
//import EquipmentDataService from "../../service/common/EquipmentDataService";
export default {
   name: "office",
    data() {
        return {
        // office: {
        //     officeId: '',
        //     officeName: '',
        //     streetAddress: '',
        //     city: '',
        //     zip: '',
        //     active: true
        // },
        // officeId: this.$route.params.officeId,
        id: this.$route.params.id,              //just added to check id is passing or no
        
        // errors: []
        };
    },
    created() {
        if(this.officeId){
        OfficeDataService.getOfficeById(this.officeId).then( result => {
            this.office = result;
        });
        }        
        // if(!this.officeId){
        // //EquipmentDataService.getEquipmentsByOfficeId(this.officeId).then( result => {
        // OfficeDataService.getAllOffices().then(result => {  
        //     this.office = result;
        // });    
        // }
    },
  components: {
        "equipment-edit-form": equipmentEditFormVue,
  },
  computed: {
    // id() {
    //   return this.$route.query.id;
    // }
  },
};
</script>
