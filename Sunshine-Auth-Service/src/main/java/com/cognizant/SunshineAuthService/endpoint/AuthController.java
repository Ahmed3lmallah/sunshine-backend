package com.cognizant.SunshineAuthService.endpoint;

import com.cognizant.SunshineAuthService.model.User;
import com.cognizant.SunshineAuthService.service.AuthService;
import com.cognizant.SunshineAuthService.views.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("encrypt")
    public String encrypt(@RequestBody String password) {
        return authService.encryptPassword(password);
    }

    @GetMapping("user/me")
    public UserViewModel me(Principal principal){
        return authService.me(principal);
    }

}
