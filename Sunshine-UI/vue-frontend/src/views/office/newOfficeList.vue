<template>
  <div class="card card-default">
    <div class="card-body">
      <b-col lg="6" class="my-1">
        <b-form-group
          label="Filter:"
          label-cols-sm="3"
          label-align-sm="right"
          label-size="sm"
          label-for="filterInput"
          class="mb-0"
        >
          <b-input-group size="sm">
            <b-form-input
              v-model="filter"
              type="search"
              id="filterInput"
              placeholder="Type to Search"
            ></b-form-input>
            <b-input-group-append>
              <button :disabled="!filter" @click="filter = ''">Clear</button>
            </b-input-group-append>
          </b-input-group>
        </b-form-group>
      </b-col>
      <div class="overflow-auto">
          <b-pagination
            v-model="currentPage"
            :total-rows="totalRows"
            :per-page="perPage"
            aria-controls="my-table"
          ></b-pagination>

        <b-table
          responsive
          striped
          hover
          :items="activeOffices"
          :fields="fieldsSortable"
          id="my-table"
          :filter="filter"
          @filtered="onFiltered"
          :per-page="perPage"
          :current-page="currentPage"
        >
          <template slot="actions" scope="row">
            <span class="fa-stack edit-office" @click="editOffice(row.item.officeId)" v-if="checkIfAdmin()">
              <i class="fas fa-edit fa-2x icon-button"></i>
              <span class="icon-tooltip fa-stack-1x font-weight-bold">Edit</span>
            </span>
            <span class="fa-stack edit-office" @click="setDelete(row.item)" v-if="checkIfAdmin()">
              <i class="far fa-trash-alt fa-2x icon-button"></i>
              <span class="icon-tooltip fa-stack-1x font-weight-bold">Delete</span>
            </span>
            <span class="fa-stack edit-office" @click="openMap(row.item)">
              <i class="fas fa-map-marker-alt fa-2x icon-button"></i>
              <span class="icon-tooltip fa-stack-1x font-weight-bold">Map</span>
            </span>
            <span class="fa-stack edit-office" @click="equipment(row.item.officeId)">
              <i class="fas fa-briefcase fa-2x icon-button"></i>
              <span class="icon-tooltip fa-stack-1x font-weight-bold">Equipments</span>
            </span>

          </template>
        </b-table>
      </div>
<!--      <div class="overflow-auto" v-else>-->
<!--        <b-pagination-->
<!--          v-model="currentPage"-->
<!--          :total-rows="totalRows"-->
<!--          :per-page="perPage"-->
<!--          aria-controls="my-table"-->
<!--        ></b-pagination>-->
<!--        <b-table-->
<!--          responsive-->
<!--          striped-->
<!--          hover-->
<!--          :items="activeOffices"-->
<!--          :fields="activeNoneAdminSortable"-->
<!--          id="my-table"-->
<!--          @filtered="onFiltered"-->
<!--          :filter="filter"-->
<!--          :per-page="perPage"-->
<!--          :current-page="currentPage"-->
<!--        ></b-table>-->
<!--      </div>-->

      <br />
      <br />
      <br />
      <div v-if="checkIfAdmin()">
        <h3>Inactive Offices</h3>
        <b-pagination
          v-model="inactiveCurrentPage"
          :total-rows="inactiveTotalRows"
          :per-page="perPage"
          aria-controls="inactive-table"
        ></b-pagination>
        <b-table
          responsive
          striped
          hover
          :items="inactiveOffices"
          :fields="adminFieldsSortable"
          id="inactive-table"
          @filtered="onFilteredInactive"
          :filter="filter"
          :per-page="perPage"
          :current-page="inactiveCurrentPage"
        >
          <template slot="actions" scope="row">
            <span class="fa-stack edit-office" @click="editOffice(row.item.officeId)">
              <i class="fas fa-edit fa-2x icon-button"></i>
              <span class="icon-tooltip fa-stack-1x font-weight-bold">Edit</span>
            </span>&nbsp;&nbsp;
          </template>
        </b-table>
      </div>

      <div id="deleteMessage" class="text-center" v-show="deleteOffice">
        Are you sure you want to delete office: {{deleteOfficeName}}?
        <br />
        <button class="btn btn-primary" @click="confirmDelete">Yes</button>
        <button class="btn btn-danger" @click="clearDelete">No</button>
      </div>
    </div>
  </div>
</template>

<script>
import officeService from "../../service/common/OfficeDataService.js";
import authService from "../../service/common/CommonCall";

export default {
  data() {
    return {
      filter: null,
      perPage: 5,
      totalRows: 1,
      inactiveTotalRows: 1,
      currentPage: 1,
      filterOn: [],
      inactiveCurrentPage: 1,
      loading: false,
      deleteOffice: false,
      idToDelete: undefined,
      deleteOfficeName: "",
      offices: [],
      watch: {
        route: "getOffices"
      },
      // activeNoneAdminSortable: {
      //   officeName: {
      //     label: "Office Name",
      //     sortable: true
      //   },
      //   streetAddress: {
      //     label: "Address",
      //     sortable: true
      //   },
      //   city: {
      //     label: "City",
      //     sortable: true
      //   },
      //   zip: {
      //     label: "Zip Code",
      //     sortable: true
      //   },
      //   state: {
      //     label: "State",
      //     sortable: true
      //   },
      //   country: {
      //     label: "Country",
      //     sortable: true
      //   }
      // },
      fieldsSortable: {
        officeName: {
          label: "Office Name",
          sortable: true
        },
        streetAddress: {
          label: "Address",
          sortable: true
        },
        city: {
          label: "City",
          sortable: true
        },
        zip: {
          label: "Zip Code",
          sortable: true
        },
        state: {
          label: "State",
          sortable: true
        },
        country: {
          label: "Country",
          sortable: true
        },
        actions: {
          label: "Actions"
        }
      },
      adminFieldsSortable: {
        officeId: {
          label: "ID",
          sortable: true
        },
        officeName: {
          label: "Office Name",
          sortable: true
        },
        streetAddress: {
          label: "Address",
          sortable: true
        },
        city: {
          label: "City",
          sortable: true
        },
        zip: {
          label: "Zip Code",
          sortable: true
        },
        state: {
          label: "State",
          sortable: true
        },
        country: {
          label: "Country",
          sortable: true
        },
        actions: {
          label: "Actions"
        }
      },
      style: {
        striped: false,
        bordered: false,
        outlined: false,
        small: false,
        hover: false,
        dark: false,
        fixed: false,
        footClone: false
      }
    };
  },
  async created() {
    this.getOffices();
  },
  methods: {
    openMap(office) {
      const url = `https://www.google.com/maps/search/${office.officeName} ${office.streetAddress} ${office.city} ${office.state} ${office.zip}`;
      window.open(url, '_blank')
    },
    equipment(id) {
      console.log("equipment method called with OfficeId = " + id);
      this.$router.push({
        name: "equipments",
        params: {
          id: id
        }
      });
    },
    checkIfAdmin() {
      return authService.checkAuthority("ROLE_ADMIN");
    },
    editOffice(id) {
      this.$router.push({
        name: "editOffice",
        params: {
          id: id
        }
      });
    },
    async getOffices() {
      const promise = officeService.getAllOffices();
      promise.then(result => {
        this.offices = result;
        this.loading = false;
      });
    },
    setDelete(office) {
      this.deleteOffice = true;
      this.idToDelete = office.officeId;
      this.deleteOfficeName = office.officeName;
    },
    clearDelete() {
      this.deleteOffice = false;
    },
    async confirmDelete() {
      const promise = officeService.deleteOffice(this.idToDelete);
      console.log(promise);
      promise.then(() => {
        this.clearDelete();
        this.getOffices();
      });
    },
    onFiltered(filteredItems) {
      //console.log("filtered Items: " + filteredItems);
      if (this.filter === "") {
        console.log("filter is empty");
        this.totalRows = this.activeOffices.length;
      } else {
        this.totalRows = filteredItems.length;
        this.inactiveCurrentPage = 1;
        this.currentPage = 1;
        console.log("total rows: " + this.totalRows);
      }
    },
    onFilteredInactive(filteredItems) {
      console.log("inactive filter running");
      if (this.filter === "") {
        console.log("inactive filter empty");
        this.inactiveTotalRows = this.inactiveOffices.length;
      } else {
        this.inactiveTotalRows = filteredItems.length;
        this.inactiveCurrentPage = 1;
      }
    }
  },
  computed: {
    activeOffices() {
      let active = this.offices.filter(office => office.active);
      this.totalRows = active.length;
      return active;
    },
    inactiveOffices() {
      let inactive = this.offices.filter(office => !office.active);
      this.inactiveTotalRows = inactive.length;
      return inactive;
    },
    // rows() {
    //   return this.activeOffices.length;
    // },
    inactiveRows() {
      return this.inactiveOffices.length;
    }
  }
};
</script>

<style>
.pagination .page-item .page-link:focus {
  background-color: #4285f4 !important;
}
</style>

<style scoped>
.inactive {
  background-color: darkgray;
}

.edit-office:hover {
  cursor: pointer;
}

.edit-office {
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  word-wrap: normal;
  color: inherit;
}

#deleteMessage {
  position: fixed;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  display: block;
  width: 100%;
  max-width: fit-content;
  color: black;
  background-color: #dee2e6;
  margin: 0;
  padding: 2.25em;
  box-sizing: border-box;
  border: solid 1px #ddd;
  border-radius: 0.5em;
  font-family: "Source Sans Pro", sans-serif;
}

.icon-tooltip {
  opacity: 0;
}

.edit-office:hover .icon-tooltip {
  opacity: 0.5;
}

.icon-button {
  opacity: 0.5;
}

.edit-office:hover .icon-button {
  opacity: 0;
}
</style>


