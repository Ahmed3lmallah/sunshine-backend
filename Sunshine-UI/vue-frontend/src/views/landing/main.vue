<template>
  <div class="div-container">
    <h1 id="title">Cognizant Location Resource Manager</h1>
    <div id="appLanding">
      <div>
        <div>
          <!-- <h2>Search and add a pin</h2> -->
          <label>
            <gmap-autocomplete @place_changed="setPlace"></gmap-autocomplete>
            <button @click="addMarker">Add</button>
          </label>
          <br />
        </div>
        <br />
        <gmap-map
          :center="center[0]"
          :options="{styles: styles}"
          style="width:100%;  height: 450px;"
          :zoom="2"
        >
          <gmap-marker
            :icon=image
            :key="index"
            v-for="(m, index) in markers"
            :position="m.position"
            @click="center=m.position"
          ></gmap-marker>
        </gmap-map>
      </div>
    </div>
  </div>
</template>
  
<script>
import officeService from "../../service/common/OfficeDataService.js";
import Vue from "vue";

export default {
  name: "appLanding",
  data() {
    return {
      loading: false,
      center: [{ lat: 30.508, lng: -73.587 },
      { lat: 35.001237, lng: -88.15932 }, 
      { lat: 20.698587, lng: 78.26626 }, 
      { lat: 49.883319, lng: 16.418917 } ],
      markers: [],
      places: [],
      currentPlace: null,
      styles: [
        {
          elementType: "geometry",
          stylers: [
            {
              color: "#485d96"
            }
          ]
        },
        {
          elementType: "labels",
          stylers: [
            {
              visibility: "off"
            }
          ]
        },
        {
          elementType: "labels.icon",
          stylers: [
            {
              visibility: "off"
            }
          ]
        },
        {
          elementType: "labels.text.fill",
          stylers: [
            {
              color: "#616161"
            }
          ]
        },
        {
          elementType: "labels.text.stroke",
          stylers: [
            {
              color: "#f5f5f5"
            }
          ]
        },
        {
          featureType: "administrative",
          elementType: "geometry",
          stylers: [
            {
              visibility: "off"
            }
          ]
        },
        {
          featureType: "administrative.land_parcel",
          elementType: "labels.text.fill",
          stylers: [
            {
              color: "#bdbdbd"
            }
          ]
        },
        {
          featureType: "administrative.neighborhood",
          stylers: [
            {
              visibility: "off"
            }
          ]
        },
        {
          featureType: "poi",
          stylers: [
            {
              visibility: "off"
            }
          ]
        },
        {
          featureType: "poi",
          elementType: "geometry",
          stylers: [
            {
              color: "#eeeeee"
            }
          ]
        },
        {
          featureType: "poi",
          elementType: "labels.text.fill",
          stylers: [
            {
              color: "#757575"
            }
          ]
        },
        {
          featureType: "poi.park",
          elementType: "geometry",
          stylers: [
            {
              color: "#e5e5e5"
            }
          ]
        },
        {
          featureType: "poi.park",
          elementType: "labels.text.fill",
          stylers: [
            {
              color: "#9e9e9e"
            }
          ]
        },
        {
          featureType: "road",
          stylers: [
            {
              visibility: "off"
            }
          ]
        },
        {
          featureType: "road",
          elementType: "geometry",
          stylers: [
            {
              color: "#ffffff"
            }
          ]
        },
        {
          featureType: "road",
          elementType: "labels.icon",
          stylers: [
            {
              visibility: "off"
            }
          ]
        },
        {
          featureType: "road.arterial",
          elementType: "labels.text.fill",
          stylers: [
            {
              color: "#757575"
            }
          ]
        },
        {
          featureType: "road.highway",
          elementType: "geometry",
          stylers: [
            {
              color: "#dadada"
            }
          ]
        },
        {
          featureType: "road.highway",
          elementType: "labels.text.fill",
          stylers: [
            {
              color: "#616161"
            }
          ]
        },
        {
          featureType: "road.local",
          elementType: "labels.text.fill",
          stylers: [
            {
              color: "#9e9e9e"
            }
          ]
        },
        {
          featureType: "transit",
          stylers: [
            {
              visibility: "off"
            }
          ]
        },
        {
          featureType: "transit.line",
          elementType: "geometry",
          stylers: [
            {
              color: "#e5e5e5"
            }
          ]
        },
        {
          featureType: "transit.station",
          elementType: "geometry",
          stylers: [
            {
              color: "#eeeeee"
            }
          ]
        },
        {
          featureType: "water",
          elementType: "geometry",
          stylers: [
            {
              color: "#F5F7FA"
            }
          ]
        },
        {
          featureType: "water",
          elementType: "labels.text.fill",
          stylers: [
            {
              color: "#9e9e9e"
            }
          ]
        }
      ]
    };
  },

  
  mounted() {
    this.geolocate();
  },
  created() {
    this.getOffices();
  },
  methods: {
    async getOffices() {
      this.loading = true;
      const promise = officeService.getAllOffices();
      promise.then(result => {
        this.offices = result;

        //here we push each office into a geocoder to parse lat and long
        // for google maps to add a marker
        result.forEach(e => {
          Vue.$geocoder.setDefaultMode("address");
          var addressObj = {
            address_line_1: e.streetAddress,
            address_line_2: "",
            city: e.city,
            state: e.state, // province also valid
            zip_code: e.zip, // postal_code also valid
            country: e.country
          };
          Vue.$geocoder.send(addressObj, res => {
            this.setPlace(res.results[0]);
            this.addMarker();
          });
        });
        this.loading = false;
      });
    },
    // receives a place object via the autocomplete component
    setPlace(place) {
      this.currentPlace = place;
    },

    addMarker() {
      if (this.currentPlace) {
        let marker;
        if (typeof this.currentPlace.geometry.location.lat === typeof 123) {
          marker = {
            lat: this.currentPlace.geometry.location.lat,
            lng: this.currentPlace.geometry.location.lng
          };
        } else {
          marker = {
            lat: this.currentPlace.geometry.location.lat(),
            lng: this.currentPlace.geometry.location.lng()
          };
        }
        this.markers.push({ position: marker });
        this.places.push(this.currentPlace);
        this.center = marker;
        this.currentPlace = null;
      }
    },
    geolocate: function() {
      navigator.geolocation.getCurrentPosition(position => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        };
      });
    }
  }
};
</script>

<style>
.div-container {
  text-align: center;
}
#appLanding {
  /* background-color: blue; */
  height: 65vh;
  width: 70vw;
  display: inline-block;
}

#title {
  padding: 20px;
}

#placeholder {
  color: white;
  text-align: center;
}

#map {
  height: 100%;
}
html,
body {
  height: 100%;
  margin: 0;
  padding: 0;
}
</style>
