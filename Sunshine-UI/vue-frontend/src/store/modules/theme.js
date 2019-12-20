/**
 * Store to handle app theme style
 */
const ThemeModule = {
    state: {
        path: null
    },
    getters: {
        getTheme(state) {
            return state.path;
        }
    },
    mutations: {
        /**
         * Change current theme path
         */
        changeTheme(state, value) {
            state.path = value;
        }
    },
    actions: {
    }
}

export default ThemeModule