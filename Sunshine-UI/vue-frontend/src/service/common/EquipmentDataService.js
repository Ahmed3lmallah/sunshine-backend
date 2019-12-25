import axios from 'axios';

const EQUIPMENT_API_URL = 'https://sunshine-fe-ms.cfapps.io'
const token = sessionStorage.getItem('access_token');
const AuthStr = `Bearer ${token}`

class EquipmentDataService {

    getAllEquipments(){
        return axios.get(EQUIPMENT_API_URL + '/api/equipments', {headers: { Authorization: AuthStr }})
            .then(response => {
                console.log(response.data);
                return response.data;
            })
    }

    getEquipmentById(equipmentId) {
        return axios.get(`${EQUIPMENT_API_URL}/api/equipments/${equipmentId}`, {headers: { Authorization: AuthStr }})
            .then(response => {
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    createEquipment(equipment) {
        console.log("creating equipment");
        console.log(equipment);
        return axios.post(`${EQUIPMENT_API_URL}/api/equipments`, equipment, {headers: { Authorization: AuthStr }})
                    .then(res => {
                        console.log(res.data)
                    })
    }

    updateEquipment(id, equipment) {
        console.log('Editing Equipment')
        return axios.put(`${EQUIPMENT_API_URL}/api/equipments/${id}`, equipment,{headers: { Authorization: AuthStr }})
            .then(res=>{
                console.log(res.data)
            })
    }

    deleteEquipment(equipmentId) {
        return axios.delete(`${EQUIPMENT_API_URL}/api/equipments/${equipmentId}`, {headers: { Authorization: AuthStr }})
            .then(res => {
                console.log("office deleted")
            })
            .catch(err => {
                console.log(`Error: ${err}`)
            })
    }
}

export default new EquipmentDataService()
