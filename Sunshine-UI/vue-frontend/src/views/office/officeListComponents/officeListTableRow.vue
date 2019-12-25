<template>
  <tr>
    <th scope="row">{{office.officeId}}</th>
    <td>{{office.officeName}}</td>
    <td>{{office.streetAddress}}</td>
    <td>{{office.city}}</td>
    <td>{{office.zip}}</td>
    <td @click="editOffice" class="edit-office text-center" v-if="isAdmin">
      <span class="fa-stack">
        <i class="fas fa-pencil-alt icon-button" ></i>
        <span class="icon-tooltip fa-stack-1x font-weight-bold">Edit</span>
      </span>
    </td>
    <td @click="$emit('delete-office', office.officeId)" class="edit-office text-center" v-if="isAdmin">
      <span class="fa-stack">
        <i class="fas fa-trash icon-button"></i>
        <span class="icon-tooltip fa-stack-1x font-weight-bold">Delete</span>
      </span>
    </td>
     <td @click="equipment" class="office-equipment text-center">
      <i class="fas fa-briefcase" title="click to view equipments"></i>
    </td>  
  </tr>
</template>

<script>
export default {
    props: {
        office: {
            type: Object,
            default: {}
        },
        isAdmin: {
          type: Boolean,
          default: true
        }
    },
    methods: {
        editOffice() {
            this.$router.push({
              name: "editOffice",
              params: {
                id: this.office.officeId
              }})
        },
         equipment() {
          this.$router.push({
            name: "equipment",
             params: {
                id: this.office.officeId
            }})
        }
    },
}
</script>

<style scoped>
  .edit-office:hover {
    cursor: pointer;
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
  }

  .edit-office {
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;

  }

  .icon-tooltip {

    opacity: 0;
  }

  .edit-office:hover .icon-tooltip {
    opacity: 1;
  }

  .icon-button {
    opacity: 1;
  }

  .edit-office:hover .icon-button {
    opacity: 0;
  }
</style>