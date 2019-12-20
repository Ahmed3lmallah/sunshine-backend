

<template>
  <div id="appLanding">
    <!-- <div id="nav">
      <button id="cogButton">Log Out</button>
      <button id="cogButton" @click="onClickOffices">Offices</button>
      <div>
        <img id="cogLogo" alt="Cognizant logo" src="../../../src/assets/CognizantLogo.png" />
        <img id="officeImage" alt="Vue logo" src="../../../src/assets/one.jpg" />
      </div>
    </div> -->


    <div>
        <!--<NavBar /> -->
      <!-- <img id="cogLogo" alt="Cognizant logo" src="../../../src/assets/CognizantLogo.png" /> -->
      <img id="officeImage" alt="Vue logo" src="../../../src/assets/Cognizant-Chennai.jpg" />
    </div>
  </div>

  <!-- <div id="appLanding">
    
  </div> -->
</template>

<script>
// import NavBar from '@/component/NavBar/navbar.vue';
import NavBar from '../../../src/components/NavBar/navbar.vue';
export default {
    name: 'appLanding',
    components: {
        NavBar
    }
};
</script>

<style>
@import "~bootstrap/dist/css/bootstrap.css";

#cogButton {
  margin-right: 10px;
  color: white;
  background-color: #002d93;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 11pt;
  padding: 10px;
  border-radius: 4px;
  box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  float: right;
  position: relative;
  top: 35px;
}

#officeImage {
  /* float: left;
  margin: 10px;
  box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  position: absolute;
  top: 75px;
  left: 70px; */
  max-width: 100%;
  height: auto;
}

#cogLogo {
  float: left;
  margin: 10px;
  position: relative;
  left: 70px;
  padding: 0.5em 1em;
  /* line-height: 2em; */
}

#nav {
  padding: 10px;
  border-radius: 4px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#appLand {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #002d93;
}
</style>