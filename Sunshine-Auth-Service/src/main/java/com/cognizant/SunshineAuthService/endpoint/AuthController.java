package com.cognizant.SunshineAuthService.endpoint;

import com.cognizant.SunshineAuthService.service.AuthService;
import com.cognizant.SunshineAuthService.views.AuthViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("encrypt")
    public String encrypt(@RequestBody String password) {
        return authService.encryptPassword(password);
    }

    @GetMapping("user/me")
    public AuthViewModel me(Principal principal){
        return authService.me(principal);
    }

}
