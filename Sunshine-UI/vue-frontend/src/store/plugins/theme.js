
const LINK_ID = 'theme-stylesheet';

const createLink = () => {
    let link = document.getElementById(LINK_ID)
    if(!link) {
        const head  = document.getElementsByTagName('head')[0];
        link  = document.createElement('link');
        link.id  = LINK_ID;
        link.rel = 'stylesheet';
        head.appendChild(link);
    }
    return link;
}

const injectStylesheet = stylesheet => {
    const linkTag = createLink();
    if(stylesheet)
        linkTag.href = stylesheet;
}

const updateTheme = state => {
    injectStylesheet(state.theme.path)
}

/*
    Hook into theme change to set a inject a selected theme
*/
const ThemePlugin = store => {
    // wait for dom ready
    document.addEventListener('DOMContentLoaded', () => updateTheme(store.state));

    store.subscribe((mutation, state) => {
        if (mutation.type === 'changeTheme') {
            updateTheme(state)
        }
    })
}

export default ThemePlugin;