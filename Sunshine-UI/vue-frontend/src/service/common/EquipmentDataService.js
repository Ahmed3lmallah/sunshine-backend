import axios from 'axios';

const EQUIPMENT_API_URL = 'https://sunshine-fe-ms.cfapps.io';

class EquipmentDataService {

    getToken(){
        return sessionStorage.getItem('access_token');
    }

    getAllEquipments(){
        return axios.get(EQUIPMENT_API_URL + '/api/equipment', {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log("All equipment fetched:");
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    getEquipmentById(equipmentId) {
        return axios.get(`${EQUIPMENT_API_URL}/api/equipment/${equipmentId}`, {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log(`Fetched equipment ${equipmentId}:`);
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    getEquipmentsByOfficeId(officeId) {
        return axios.get(`${EQUIPMENT_API_URL}/api/equipment/office/${officeId}`, {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log(`Fetched equipment for office ${officeId}:`);
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    createEquipment(equipment) {
        return axios.post(`${EQUIPMENT_API_URL}/api/equipment/register`, equipment, {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log("Created equipment:");
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    updateEquipment(id, equipment) {
        return axios.put(`${EQUIPMENT_API_URL}/api/equipment/${id}`, equipment,{headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response=>{
                console.log("Edited equipment:");
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    deleteEquipment(equipmentId) {
        return axios.delete(`${EQUIPMENT_API_URL}/api/equipment/${equipmentId}`, {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }
}

export default new EquipmentDataService()
