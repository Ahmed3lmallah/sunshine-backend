<template>
  <tr>
    <th scope="row">{{office.officeId}}</th>
    <td>{{office.officeName}}</td>
    <td>{{office.streetAddress}}</td>
    <td>{{office.city}}</td>
    <td>{{office.zip}}</td>
    <td @click="editOffice" class="edit-office text-center">
      <i class="fas fa-pencil-alt" ></i>
    </td>
    <td @click="$emit('delete-office', office.officeId)" class="edit-office text-center">
      <i class="fas fa-trash"></i>
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
    },
    methods: {
        editOffice() {
            this.$router.push({
              path: "officeEdit",
              query: {
                id: this.office.officeId
              }})
        },
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
</style>