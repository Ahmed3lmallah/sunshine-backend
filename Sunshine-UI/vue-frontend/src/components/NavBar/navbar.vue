<template>
  <mdb-navbar expand="large" dark id="nBar">
    <!-- <a href="/main" class="navbar-brand">Cognizant</a> -->
    <a @click="goToMain" class="navbar-brand" id="homeButton">Cognizant</a>
    <mdb-navbar-toggler>
      <mdb-navbar-nav right>
        <!-- <mdb-nav-item href="/officeList" active id="drop">To Office</mdb-nav-item> -->
        <mdb-nav-item @click="goToOfficeList" active id="drop">To Office</mdb-nav-item>
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
      this.$router.push({path: "main"})
    },
    goToLogin(){
      this.$router.push({path: "login"})
    },
    goToOfficeList(){
      this.$router.push({path: "officeList"})
    },
    logout() {
      sessionStorage.clear();
      this.$router.push({path: "login"});
    }

  }
};
</script>