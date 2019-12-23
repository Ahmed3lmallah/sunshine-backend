package com.cognizant.SunshineAuthService.service;

import com.cognizant.SunshineAuthService.model.Role;
import com.cognizant.SunshineAuthService.model.User;
import com.cognizant.SunshineAuthService.repository.RoleRepository;
import com.cognizant.SunshineAuthService.repository.UserRepository;
import com.cognizant.SunshineAuthService.views.UserViewModel;
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

    public void register(String username, String password, Boolean passwordEncoded, String... roleNames) {
        User user = new User();

        //
        user.setUsername(username);
        if(passwordEncoded){
            user.setPassword(password);
        } else {
            user.setPassword(passwordEncoder.encode(password));
        }
        //save
        user = userRepository.save(user);
        //check the role
        Set<Role> roles = new HashSet<>();
        if (roleNames.length != 0) {
            for (String roleName : roleNames) {
                Role role = roleRepository.findByName(roleName);
                roles.add(role);
            }//end for
        } else {
            roles.add(roleRepository.findByName("ROLE_DEVELOPER"));
        }//end if
        //update the user
        user.setRoles(roles);
        //save
        userRepository.save(user);
    }

    public UserViewModel me(Principal principal){
        return userToViewModel(userRepository.findByUsername(principal.getName()));
    }

    /*
    HELPER METHOD
        Transforms User model to the UserView to hide password.
     */
    private UserViewModel userToViewModel(User user) {
        UserViewModel userViewModel = new UserViewModel();
        userViewModel.setId(user.getId());
        userViewModel.setUsername(user.getUsername());
        userViewModel.setFirstName(user.getFirstName());
        userViewModel.setLastName(user.getLastName());
        userViewModel.setEmail(user.getEmail());
        userViewModel.setDepartment(user.getDepartment());
        userViewModel.setRoles(user.getRoles());
        return userViewModel;
    }
}
