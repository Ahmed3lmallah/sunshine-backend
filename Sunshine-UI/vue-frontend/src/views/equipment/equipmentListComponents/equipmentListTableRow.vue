<template>
  <tr>
    <th scope="row">{{equipment.equipmentId}}</th>
    <td>{{equipment.equipmentType}}</td>
    <td @click="editEquipment" class="edit-equipment text-center">
      <i class="fas fa-pencil-alt" title="Click to edit equipment" ></i>
    </td>
    <td @click="$emit('delete-equipment', equipment.equipmentId)" class="edit-equipment text-center">
      <i class="fas fa-trash" title="Click to delete equipment"></i>
    </td>
    <td @click="equipmentDetail" class="equipment-detail text-center">
      <i class="fas fa-eye" title="Click to view equipment details"></i>
    </td>  

    {{office.officeId}}

  </tr>
</template>

<script>
export default {
    props: {
        equipment: {
            type: Object,
            default() {
              return {}
            }
        },
        office:{
            type: Object,
            default() {
              return {}
            }
        }
    },
    methods: {
        editEquipment() {
            this.$router.push({
              name: "editEquipment",
              params: {
                //id: this.equipment.equipmentId,
                officeId: this.$route.params.id
              }})
        },
        equipmentDetail() {
          this.$router.push({
              name: "equipmentDetail",
              params: {
                  id: this.equipment.equipmentId
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
</style>