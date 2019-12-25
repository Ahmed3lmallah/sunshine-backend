import axios from 'axios';


const OFFICE_API_URL = 'https://sunshine-fe-ms.cfapps.io'
const token = sessionStorage.getItem('access_token');
const AuthStr = `Bearer ${token}`

class OfficeDataService {

    getAllOffices(){
        return axios.get(OFFICE_API_URL + '/api/offices', {headers: { Authorization: AuthStr }})
            .then(response => {
                console.log(response.data);
                return response.data;
            })
    }

    getOfficeById(officeId) {
        return axios.get(`${OFFICE_API_URL}/api/offices/${officeId}`, {headers: { Authorization: AuthStr }})
            .then(response => {
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    createOffice(office) {
        console.log("creating office");
        console.log(office);
        return axios.post(`${OFFICE_API_URL}/api/offices`, office, {headers: { Authorization: AuthStr }})
                    .then(res => {
                        console.log(res.data)
                    })
                    
    }

    updateOffice(id, office) {
        console.log('Editing Office')
        return axios.put(`${OFFICE_API_URL}/api/offices/${id}`, office,{headers: { Authorization: AuthStr }})
            .then(res=>{
                console.log(res.data)
            })
    }

    deleteOffice(officeId) {
        return axios.delete(`${OFFICE_API_URL}/api/offices/${officeId}`, {headers: { Authorization: AuthStr }})
            .then(res => {
                console.log("office deleted")
            })
            .catch(err => {
                console.log(`Error: ${err}`)
            })
    }
}

export default new OfficeDataService()
