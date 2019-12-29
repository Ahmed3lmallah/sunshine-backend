import axios from 'axios';

const USER_API_URL = 'https://sunshine-fe-ms.cfapps.io';

class UserDataService {

    getToken(){
        return sessionStorage.getItem('access_token');
    }

    getAllUsers(){
        return axios.get(USER_API_URL + '/api/users', {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log("All users fetched:");
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    getUserByUsername(username) {
        return axios.get(USER_API_URL + '/api/users/' + username, {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log(`User [${username}] fetched:`);
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    getUsersByManagerId(managerId) {
        return axios.get(USER_API_URL + '/api/users/manager/' + managerId, {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log(`Users fetched for manager ${managerId}:`);
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    createUser(user) {
        return axios.post(`${USER_API_URL}/api/users`, user, {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log(`User [${user.username}] added:`);
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    registerUser(user) {
        return axios.post(`${USER_API_URL}/api/users/register`, user)
            .then(response => {
                console.log(`User [${user.username}] registered:`);
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }


    updateUser(username, user) {
        console.log(user);
        return axios.put(`${USER_API_URL}/api/users/${username}`, user, {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log(`User [${username}] edited:`);
                console.log(response.data);
                return response.data;
            }).catch( error => {
                console.log(`Error: ${error}`)
            })
    }

    deleteUser(username) {
        return axios.delete(`${USER_API_URL}/api/users/${username}`, {headers: { Authorization: `Bearer ${this.getToken()}` }})
            .then(response => {
                console.log(response.data);
                return response.data;
            }).catch(error => {
                console.log(`Error: ${error}`)
            })
    }
}

export default new UserDataService()
