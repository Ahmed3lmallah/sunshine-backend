<template>
  <div>
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
  import equipmentListTableRow from "./equipmentListTableRow";
  import equipmentService from "../../../service/common/OfficeDataService.js"
  export default {
    data() {
      return {
        equipments: {
          equipmentId: '',
          equipmentType: ''
        },
        id:this.$route.params.id,
        errors: [],
        loading: false,
        deleteEquipment: false,
        idToDelete: 1
      };
    },
    created() {
      //this.getEquipments();

    },
    methods: {
      async getEquipments() {
        this.loading = true
        const promise =    equipmentService.getAllEquipmentsByOfficeID(this.id);
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
      "table-row": equipmentListTableRow,
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
