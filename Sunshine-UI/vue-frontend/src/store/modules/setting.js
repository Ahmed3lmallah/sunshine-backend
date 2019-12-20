/**
 * Setting store to control layout behavior
 */
const SettingModule = {
    state: {
        /* Layout fixed. Scroll content only */
        isFixed: true,
        /* Sidebar collapsed */
        isCollapsed: false,
        /* Boxed layout */
        isBoxed: false,
        /* Floating sidebar */
        isFloat: false,
        /* Sidebar show menu on hover only */
        asideHover: false,
        /* Show sidebar scrollbar (dont' hide it) */
        asideScrollbar: false,
        /* Sidebar collapsed with big icons and text */
        isCollapsedText: false,
        /* Toggle for the offsidebar */
        offsidebarOpen: false,
        /* Toggle for the sidebar offcanvas (mobile) */
        asideToggled: false,
        /* Toggle for the sidebar user block */
        showUserBlock: false,
        /* Enables layout horizontal */
        horizontal: false,
        /* Full size layout */
        useFullLayout: false,
        /* Hide footer */
        hiddenFooter: false
    },
    getters: {
        getSetting(state) {
            return state;
        }
    },
    mutations: {
        /**
         * Toggle a setting value (only boolean)
         */
        toggleSetting(state, name) {
            if(name in state)
                state[name] = !state[name];
        },
        /**
         * Change a setting value
         * payload.name: name of the setting prop to change
         * payload.value: new value to apply
         */
        changeSetting(state, {name, value}) {
            if(name in state)
                state[name] = value;
        }
    },
    actions: {
    }
}

export default SettingModule