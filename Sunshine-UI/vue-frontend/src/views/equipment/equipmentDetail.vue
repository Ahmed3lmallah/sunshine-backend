<template>
    <div class="container">
      <div class="content-heading text-center">
        <h1 v-if="id">Equipment Details</h1>
      </div>
      <form class="jumbotron jumbotron-fluid">
        <div class="form-group">
          <button v-on:click="redirect" type="button" class="close text-danger" aria-label="Close">
            <span aria-hidden="true">
              <i class="far fa-times-circle"></i>
            </span>
          </button>
        </div>
        <div class="form-group">
          <label for="equipmentId" class="lblTitle">Equipment Id: </label>
          <label for="equipmentId" id="equipmentId" class="actualData"> {{equipment.equipmentId}} </label>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="officeId" class="lblTitle">Office Id:  </label>&nbsp;&nbsp;
            <!--<input type="text" class="form-control" id="inputType" v-model="equipment.equipmentType" />-->
             <label for="officeId" id="officeId" class="actualData">{{equipment.officeId}}</label>
          </div>
        </div>  
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="type" class="lblTitle">Type: </label>&nbsp;&nbsp;
            <label for="type" id="type" class="actualData">{{equipment.equipmentType}}</label>
          </div>
        </div>  
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="userId" class="lblTitle">Status: </label>
            <label class="actualData" v-if="equipment.assigned">Assigned</label>
            <label class="actualData" v-else>Unassigned</label>
<!--            <input type="radio" name="Assigned" value="Assigned" v-if="equipment.assigned = 'true'" checked="checked" > &nbsp;-->
<!--            <input type="radio" name="Assigned" value="Unassigned" v-if="equipment.assigned = 'false'" checked="checked" >-->
          </div>
        </div>  
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="userId" class="lblTitle">User Id: </label>&nbsp;&nbsp;
            <label for="userId" id="userId" class="actualData">{{equipment.userId}}</label>
          </div>
        </div>  
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="comment" class="lblTitle">Comments: </label>&nbsp;&nbsp;
            <label for="comment" id="comment" class="actualData">{{equipment.comment}}</label>
          </div>
        </div>  

      </form>
    </div>
</template>

<script>
import EquipmentDataService from "../../service/common/EquipmentDataService";
export default {
  name: "equipment",
  data() {
    return {
      equipment: {
        equipmentId: '',
        equipmentType: '',
        officeId: '',
        assigned: '',
        userId: '',
        comments: ''
      },
      id: this.$route.params.id,
      
    };
  },
  created() {
    if(this.id){
      EquipmentDataService.getEquipmentById(this.id).then( result => {
        this.equipment = result;
      });
    }
  },
  methods: {

      cancelForm: function(event){
        event.preventDefault();
        this.$router.push({name: "equipments"});
      },

      redirect: function (event) {
       this.$router.push({name: "allEquipments"});
      },

      }
};
</script>

<style >
.lblTitle{
  font-family:Verdana, Geneva, Tahoma, sans-serif;
  font-size: 10pt;
  font-weight: 200;
  color:#000066;
}

.actualData{
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  font-size: 18pt;
  font-weight: 200;
  color:red;
}
</style>
