<template>
    <div class="container">

        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputType">Type</label>&nbsp;&nbsp;
            <!--<input type="text" class="form-control" id="inputType" v-model="equipment.equipmentType" />-->
            <select id="equipmentType">
                <option value="Hardware">Hardware</option>
                <option value="Furniture">Furniture</option>
                <option value="Kitchen">Kitchen</option>
                <option value="Stationary">Stationary</option>
                <option value="Utility">Utility</option>        
                <option value="Transportation">Transportation</option>        
                <option value="Electonics">Electonics</option>        
            </select>
          </div>
        </div>  
        <!--       -->
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputType">Status</label>&nbsp;&nbsp;
                <select id="equipmentStatus">
                    <option value="Assigned">Assigned</option>
                    <option value="Unassigned">Unassigned</option>
                </select>
          </div>
        </div>      
        <!--       -->
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputType">Comments</label>&nbsp;&nbsp;
                <textarea id="comments" cols="60" rows="8" v-model="equipment.comments" ></textarea>
                 
          </div>
        </div>      
         
        <!--- UserId text box, Comment Text box --> 




        <div class="form-group text-center">
          <button @click="validateAndSubmit" class="btn btn-lg btn-primary">Save</button>
          <button @click="cancelForm" class="btn btn-lg btn-danger ml-2">Cancel</button>
        </div>
      </form>
    </div>
</template>

<script>
//import OfficeDataService from "../../service/common/OfficeDataService";

//import EquipmentDataService from "../../service/common/EquipmentDataService";
export default {
    name: "equipment",
    data() {
        return {
        equipment: {
            equipmentType: 'Hardware',
            status:'Assigned',
            comments:'Test comments'
        },
        id: this.$route.params.id,
        errors: []
        };
    },
  created() {
    /*if(this.id){
      EquipmentDataService.getEquipmentById(this.id).then( result => {
        this.equipment = result;
      });
    }*/
  },
  computed: {
    // id() {
    //   return this.$route.query.id;
    // }
  },
  methods: {

      cancelForm: function(event){
        event.preventDefault();
        this.$router.push({name: "equipment"});
      },

      redirect: function (event) {
       this.$router.push({name: "equipment"});
      },
    //this code checks the validity of the fields

    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
      /*if (!this.office.equipmentType) {
        this.errors.push("Enter valid values");
      }*/
      if (!this.equipment.comments) {
        this.errors.push("Enter valid comments");
      }
      //When the user input is valid, if there is no id in the path
      //then the office is saved to the database and the app is routed to officeList
      if (this.errors.length === 0) {
        if (!this.id) {
          EquipmentDataService.createEquipment(this.equipment).then(() => {
            this.$router.push({name: "equipments"});
          });
        }

        //When the user input is valid, if there is id in the path
        //then the office is updated in the database and the app is routed to officeList
        else {
          EquipmentDataService.updateEquipment(this.id, this.equipment).then(() => {
            this.$router.push({name: "equipments"});
          });
        }
      }
    }
  }
};
</script>
