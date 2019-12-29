<template>
    <div class="container">
          <div v-if="errors.length">
            <div class="alert alert-warning" v-bind:key="index" v-for="(error, index) in errors">{{error}}</div>
          </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="equipmentType">Type</label>&nbsp;&nbsp;
                <!--<input type="text" class="form-control" id="inputType" v-model="equipment.equipmentType" />-->
                <select id="equipmentType" class="custom-select" v-model="equipment.equipmentType" >
                    <option value="Windows Laptop">Windows Laptop</option>
                    <option value="Apple Mac">Apple Mac</option>
                    <option value="Printer">Printer</option>
                    <option value="Keyboard">Keyboard</option>
                    <option value="Monitor">Monitor</option>
                    <option value="Desktop Computer">Desktop Computer</option>
                    <option value="Scanner">Scanner</option>
                </select>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="officeId" id="officeDetails">Select Office</label>
                <select class="custom-select" name="officeId" id="officeId" v-model="equipment.officeId">
                    <option v-for="officeRow in offices" v-bind:key="officeRow.officeId" :value="officeRow.officeId" >
                        {{ officeRow.officeName }}
                    </option>
                </select>
            </div>
            <div class="form-group col-md-3">
                <label for="equipmentStatus">Assigned</label>&nbsp;&nbsp;
                <select id="equipmentStatus" class="custom-select" v-model="equipment.assigned" >
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                </select>
            </div>
            <div class="form-group col-md-3">
                <label for="userId">User ID</label>&nbsp;&nbsp;
                <input type="number" class="form-control" id="userId" v-model="equipment.userId">
            </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="comments">Comments</label>&nbsp;&nbsp;
                <textarea id="comments" class="form-control" cols="60" rows="8" v-model="equipment.comment" ></textarea>
                 
          </div>
        </div>

        <div class="form-group text-center">
          <button @click="validateAndSubmit" class="btn btn-lg btn-primary">Save</button>
          <button @click="cancelForm" class="btn btn-lg btn-danger ml-2">Cancel</button>
        </div>
      
    </div>
</template>

<script>
import OfficeDataService from "../../service/common/OfficeDataService";

import EquipmentDataService from "../../service/common/EquipmentDataService";
import authService from "../../service/common/CommonCall";
export default {
    // props: {
    //     office:{
    //         type: Object,
    //         default() {
    //           return {
    //             office: {
    //                 officeId: '',
    //                 officeName: '',
    //                 streetAddress: '',
    //                 city: '',
    //                 zip: '',
    //                 active: true
    //             }
    //           }
    //         }
    //     }
    // },

    name: "equipment",
    data() {
        return {
            offices: {

            },
            equipment: {
              equipmentType: "",
              officeId: "",
              assigned: "",
              userId: authService.getToken().user_name,
              comment: ""
            },
            id: this.$route.params.id,
            errors: []
            };
    },
    /*async getOffices() {
      //console.log("start");
      //console.log(officeService.getAllOffices());
      const promise = OfficeDataService.getAllOffices();
      console.log(promise);
      promise.then(result => {
        this.offices = result;
        this.loading = false;
      });
      //console.log(this.offices);
      //console.log("end");
    },
    */
  created() {
    OfficeDataService.getAllOffices().then( result => {
      this.offices = result;
      console.log("office = " + result);
      if (this.id) {
          EquipmentDataService.getEquipmentById(this.id).then(result => {
              this.equipment = result;
          });
      }
    }

    )
    // if(this.id){
    //   EquipmentDataService.getEquipmentById(this.id).then( result => {
    //     this.equipment = result;
    //   });
    // }
  },
  methods: {
      cancelForm: function(event){
        event.preventDefault();
        this.$router.push({name: "allEquipments"});
      },

      redirect: function (event) {
       this.$router.push({name: "equipments"});
      },
    //this code checks the validity of the fields

    validateAndSubmit(e) {
      console.log("validateAndSubmit function called.");
      e.preventDefault();
      this.errors = [];
      if (!this.equipment.comment) {
        this.errors.push("Enter valid comments");
      }
      console.log("Errors Length: " + this.errors.length);
      //When the user input is valid, if there is no id in the path
      //then the office is saved to the database and the app is routed to officeList
      if (this.errors.length === 0) {
        if (!this.id) {
          EquipmentDataService.createEquipment(this.equipment).then(() => {
            this.$router.push({name: "allEquipments"});
          });
        }

        //When the user input is valid, if there is id in the path
        //then the office is updated in the database and the app is routed to officeList
        else {
          EquipmentDataService.updateEquipment(this.id, this.equipment).then(() => {
            this.$router.push({name: "allEquipments"});
          });
        }
      }
    }
  }
};
</script>
