import { AuthService } from '../service/auth/';

const AuthGuard = {
    canActivate: (from) => {
        if (AuthService.getToken()) {
            if (AuthService.getToken().exp > (Date.now() / 1000))
                return true;
        }
        this.$router.push({ name: 'user', params: { returnUrl: from } });
    }
}

export { AuthGuard };
