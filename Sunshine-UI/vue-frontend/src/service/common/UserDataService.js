import axios from 'axios';


const USER_API_URL = 'https://sunshine-fe-ms.cfapps.io'
const token = sessionStorage.getItem('access_token');
const AuthStr = `Bearer ${token}`

class UserDataService {

    async getAllUsers(){
        const response = await axios.get(USER_API_URL + '/api/users', { headers: { Authorization: AuthStr } });
        console.log(response.data);
        return response.data;
    }

    async getUserByName(username) {
        console.log("this.getUserByName", username)
        try {
            const response = await axios.get(USER_API_URL + '/api/users/' + username, { headers: { Authorization: AuthStr } });
            console.log(response.data);
            return response.data;
        }
        catch (error) {
            console.log(`Error: ${error}`);
        }
    }

    async createUser(user) {
        console.log("creating user");
        console.log(AuthStr);
        const res = await axios.post(`${USER_API_URL}/api/users`, user, { headers: { Authorization: AuthStr } });
        console.log(res.data);
    }

    async updateUser(id, user) {
        console.log('Editing user')
        const res = await axios.put(`${USER_API_URL}/api/users/${id}`, user, { headers: { Authorization: AuthStr } });
        console.log(res.data);
    }

    async deleteUser(username) {
        try {
            const res = await axios.delete(`${USER_API_URL}/api/users/${username}`, { headers: { Authorization: AuthStr } });
            console.log("user deleted");
        }
        catch (err) {
            console.log(`Error: ${err}`);
        }
    }
}

export default new UserDataService()
