<template>
  <mdb-navbar expand="large" dark id="nBar">
    <!-- <a href="/main" class="navbar-brand">Cognizant</a> -->
    <a @click="goToMain" class="navbar-brand" id="homeButton">Cognizant</a>
    <mdb-navbar-toggler>
      <mdb-navbar-nav right>
        <!-- <mdb-nav-item href="/officeList" active id="drop">To Office</mdb-nav-item> -->
        <mdb-nav-item @click="goToOfficeList" active id="drop">To Office</mdb-nav-item>
        <mdb-nav-item @click="goToEquipmentList" active id="drop">To Equipments</mdb-nav-item>
        <mdb-nav-item @click="goToUserList" active id="drop">To User</mdb-nav-item>
        <mdb-nav-item @click="goToReport" active id="drop">Reports</mdb-nav-item>
        <mdb-nav-item @click="logout" id="drop">Logout</mdb-nav-item>
        <!-- this goToLogin messes up the CSS for some reason -->
        <!-- <mdb-nav-item @click="goToLogin" id="drop">Logout</mdb-nav-item> -->
      </mdb-navbar-nav>
    </mdb-navbar-toggler>
  </mdb-navbar>
</template>

<style>
  #nBar {
    background-color: #002d93;
    /* display: inline-block; */
  }
  #homeButton {
    color: white;
  }
  #drop {
    text-align: right;
  }
</style>


<script>
  import {
    mdbDropdown,
    mdbDropdownToggle,
    mdbDropdownMenu,
    mdbDropdownItem,
    mdbContainer,
    mdbNavbar,
    mdbNavbarBrand,
    mdbNavbarToggler,
    mdbNavbarNav,
    mdbNavItem
  } from "mdbvue";
  export default {
    name: "HelloWorld",
    components: {
      mdbNavbar,
      mdbNavbarBrand,
      mdbNavbarToggler,
      mdbNavbarNav,
      mdbNavItem,
      mdbContainer,
      mdbDropdown,
      mdbDropdownToggle,
      mdbDropdownMenu,
      mdbDropdownItem
    },
    methods: {
      goToMain(){
        this.$router.push({name: "main"})
      },
      goToLogin(){
        this.$router.push({name: "login"})
      },
      goToOfficeList(){
        this.$router.push({name: "offices"})
      },
      goToEquipmentList(){
      this.$router.push({name: "allEquipments"})
      },
      goToUserList(){
        this.$router.push({path: "users"})
      },
      goToReport(){
        this.$router.push({path: "report"})
      },
      
      logout() {
      this.$store.dispatch('login/logout')
           .then((response) => {
             console.log("Got logout response " + response);
             this.$router.push({name: "login"})
       })
      } 

    }
  };
</script>
