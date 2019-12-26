package com.cognizant.SunshineAuthService.service;

import com.cognizant.SunshineAuthService.model.Role;
import com.cognizant.SunshineAuthService.model.User;
import com.cognizant.SunshineAuthService.repository.RoleRepository;
import com.cognizant.SunshineAuthService.repository.UserRepository;
import com.cognizant.SunshineAuthService.views.AuthViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public void register(String username, String password, String firstName, String lastName, String email, String department,
                         Long managerId, String role) {
        User user = new User();

        // Persisting User
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setDepartment(department);
        user.setManagerId(managerId);
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(roleRepository.findByName(role));

        // Saving User
        userRepository.save(user);
    }

    public AuthViewModel me(Principal principal){
        return userToViewModel(userRepository.findByUsername(principal.getName()));
    }

    /*
    HELPER METHOD
        Transforms User model to the UserView to hide password.
     */
    private AuthViewModel userToViewModel(User user) {
        AuthViewModel authViewModel = new AuthViewModel();
        authViewModel.setId(user.getId());
        authViewModel.setUsername(user.getUsername());
        authViewModel.setFirstName(user.getFirstName());
        authViewModel.setLastName(user.getLastName());
        authViewModel.setEmail(user.getEmail());
        authViewModel.setDepartment(user.getDepartment());
        authViewModel.setManagerId(user.getManagerId());
        authViewModel.setActive(user.isActive());

        /*
        SET ROLES
         */
        Set<Role> authorities = new HashSet<>();
        switch (user.getRole().getName()){
            case "DEVELOPER":
                authorities.add(roleRepository.findByName("DEVELOPER"));
                break;
            case "MANAGER":
                authorities.add(roleRepository.findByName("DEVELOPER"));
                authorities.add(roleRepository.findByName("MANAGER"));
                break;
            case "ADMIN":
                authorities.add(roleRepository.findByName("DEVELOPER"));
                authorities.add(roleRepository.findByName("MANAGER"));
                authorities.add(roleRepository.findByName("ADMIN"));
                break;
        }

        authViewModel.setRoles(authorities);
        return authViewModel;
    }
}
