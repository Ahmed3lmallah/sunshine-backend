<template>
  <div>
    <table class="table table-hover table-dark mt-3">
      <thead>
        <tr>
          <th scope = "col">ID</th>
          <th scope = "col">Office Name</th>
          <th scope = "col">Address</th>
          <th scope = "col">City</th>
          <th scope = "col">Zip Code</th>
          <th scope = "col" v-if="isAdmin"></th>
          <th scope = "col" v-if="isAdmin"></th>
        </tr>
      </thead>
      <tbody v-if="isAdmin">
        <table-row 
          v-for="office in activeOffices" 
          :key="office.officeId" 
          :office="office"
          :isAdmin="isAdmin"
          @delete-office="setDelete"/>
        <table-row class="inactive"
          v-for="office in inactiveOffices" 
          :key="office.officeId" 
          :office="office"
          @delete-office="setDelete"
          />
      </tbody>
    </table>
    <div class="text-center" v-show="loading">Loading Offices...</div>
    <div class="text-center" v-show="deleteOffice">
      Are you sure you want to delete office {{idToDelete}}?<br/>
      <button class="btn btn-primary" @click="confirmDelete">Yes</button>
      <button class="btn btn-danger" @click="clearDelete">No</button>
    </div>
  </div>
</template>

<script>
    import officeListTableRow from "./officeListTableRow";
    import officeService from "../../../service/common/OfficeDataService.js"

    export default {
      data() {
        return {
         offices: [],
         loading: false,
         deleteOffice: false,
         idToDelete: 1
        };
       },
       props: {
         isAdmin: {
           type: Boolean,
           default: false
         },
       },
      created() {
        this.getOffices();
      },
      methods: {
        async getOffices() {
          this.loading = true
          const promise = officeService.getAllOffices();
          promise.then(result => {
          this.offices = result
          this.loading = false
          })
        },
        setDelete(id) {
          this.deleteOffice = true
          this.idToDelete = id
        },
        clearDelete() {
          this.deleteOffice = false
        },
        async confirmDelete() {
          const promise = officeService.deleteOffice(this.idToDelete)
          promise.then(res => {
            this.clearDelete()
            this.getOffices()
          })
        }
      },
      components: {
        "table-row": officeListTableRow,
      },
      watch: {
        "route": "getOffices"
      },
      computed: {
        activeOffices() {
          let active = this.offices.filter(office => office.active)
          return active 
        },
        inactiveOffices() {
          let inactive = this.offices.filter(office => !office.active);
          return inactive;
        },

      },
    }
</script>

<style>
  .inactive{
    background-color: darkgray;
  }
</style>
