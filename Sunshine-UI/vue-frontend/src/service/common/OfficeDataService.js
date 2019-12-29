import axios from 'axios';

const OFFICE_API_URL = 'https://sunshine-fe-ms.cfapps.io';

class OfficeDataService {

    getToken(){
        return sessionStorage.getItem('access_token');
    }

    getAllOffices(){
        return axios.get(OFFICE_API_URL + '/api/offices', {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log("All offices fetched:");
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    getOfficeById(officeId) {
        return axios.get(`${OFFICE_API_URL}/api/offices/${officeId}`, {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log(`Office ${officeId} fetched:`);
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    getOfficeByManagerId(managerId) {
        return axios.get(`${OFFICE_API_URL}/api/offices/manager/${managerId}`, {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log(`Office managed by ${managerId} fetched:`);
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    createOffice(office) {
        return axios.post(`${OFFICE_API_URL}/api/offices`, office, {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log("Office Created:");
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
                    
    }

    updateOffice(officeId, office) {
        return axios.put(`${OFFICE_API_URL}/api/offices/${officeId}`, office,{headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log(`Office ${officeId} Edited:`);
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    deleteOffice(officeId) {
        return axios.delete(`${OFFICE_API_URL}/api/offices/${officeId}`, {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }
}

export default new OfficeDataService()
