<template>

      <div class="container">
        <div class="text-center">
          <button class="btn btn-primary text-center add-btn" @click="addEquipment">Add equipment</button>
        </div>
    <table class="table table-hover table-dark mt-3">
      <thead>
        <tr>
          <th scope = "col">Equipment ID</th>
          <th scope = "col">Type</th>
          
        </tr>
      </thead>
      <tbody>
        <table-row 
          v-for="equipment in equipments" :key="equipment.equipmentId" :equipment="equipment"
          @delete-equipment="setDelete"/>
        <!--<table-row 
          v-for="equipment in activeEquipments" :key="equipment.equipmentId" :equipment="equipment"
          @delete-equipment="setDelete"/>-->
        <!--<table-row class="inactive"
          v-for="equipment in inactiveEquipments" :key="equipment.equipmentId" :equipment="equipment"
          @delete-equipment="setDelete"/> -->
      </tbody>
    </table>
    <div class="text-center" v-show="loading">Loading Equipments...</div>
    <div class="text-center" v-show="deleteEquipment">
      Are you sure you want to delete equipment {{idToDelete}}?<br/>
      <button class="btn btn-primary" @click="confirmDelete">Yes</button>
      <button class="btn btn-danger" @click="clearDelete">No</button>
    </div>
  </div>
</template>

<script>
    import newEquipmentListTableRow from "./equipmentListComponents/newEquipmentListTableRows.vue";
    //import equipmentService from "../../../service/common/OfficeDataService.js"

    export default {
      data() {
        return {
         equipments: [
               { equipmentId: '101', equipmentType:'Hardware' },
               { equipmentId: '102', equipmentType:'Stationary' }, 
               { equipmentId: '103', equipmentType:'Furniture' }, 
               { equipmentId: '104', equipmentType:'Kitchen' }, 
         ],
         loading: false,
         deleteEquipment: false,
         idToDelete: 1
        };
       },
      created() {
        //this.getEquipments();
        
      },
      methods: {
        addEquipment() {
      //this.$router.push({name: "addEquipment"})
        this.$router.push({
              name: "addEquipment",
            })
        },
        async getEquipments() {
          this.loading = true
          //const promise =    equipmentService.getAllEquipmentsByOfficeID(this.id);
          promise.then(result => {
          this.equipments = result
          this.loading = false
          })
        },
        setDelete(id) {
          this.deleteEquipment = true
          this.idToDelete = id
        },
        clearDelete() {
          this.deleteEquipment = false
        },
        async confirmDelete() {
          const promise = equipmentService.deleteEquipment(this.idToDelete)
          promise.then(res => {
            this.clearDelete()
            this.getEquipments()
          })
        }
      },
      components: {
        "table-row": newEquipmentListTableRow,
      },
      watch: {
        "route": "getEquipments"
      },
      computed: {
        activeEquipments() {
          let active = this.equipments.filter(equipment => equipment.active)
          return active 
        },
        // inactiveOffices() {
        //   let inactive          = this.offices.filter(office => !office.active);
        //   return inactive;
        // }
      },
    }
</script>

<style>
  .inactive{
    background-color: darkgray;
  }
</style>
