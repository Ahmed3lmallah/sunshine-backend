import authService from '../service/common/CommonCall'
import Router from '../router';

const AuthGuard = {
    canActivate: (to) => {
        if (authService.getToken()) {
            if (authService.getToken().exp > (Date.now() / 1000))
                return true;
        }
        console.log("No Authority!!");
        Router.push({ name: 'login', params: { returnUrl: to } });
    }
};

export { AuthGuard };
