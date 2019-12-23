package com.cognizant.SunshineAuthService.service;

import com.cognizant.SunshineAuthService.model.Role;
import com.cognizant.SunshineAuthService.model.User;
import com.cognizant.SunshineAuthService.repository.RoleRepository;
import com.cognizant.SunshineAuthService.repository.UserRepository;
import com.cognizant.SunshineAuthService.views.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UserViewModel findByUsername(String username) {
        return userToViewModel(userRepository.findByUsername(username));
    }

    public List<UserViewModel> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserViewModel> userViewModelList = new ArrayList<>();

        users.forEach( user -> {
            UserViewModel userViewModel = userToViewModel(user);
            userViewModelList.add(userViewModel);
        });

        return userViewModelList;
    }

    public UserViewModel register(User user){

        /*
        Validation Step:
            Make sure user doesn't already exist.
         */
        try{
            findByUsername(user.getUsername());
            throw new IllegalArgumentException("User already exist!");
        } catch (NullPointerException e){
            System.out.println("User doesn't exist!");
        }

        /*
        Set Roles:
            If no roles objects assigned (public registration) assign developer role.
         */
        if (user.getRoles().size() == 0) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_DEVELOPER"));
            user.setRoles(roles);
        }

        // Encoding password
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Password must be provided for user to be registered!");
        }

        userRepository.save(user);
        return userToViewModel(user);
    }

    public String deleteUserByUsername(String userName) {
        User user = userRepository.findByUsername(userName);
        user.setActive(false);
        userRepository.save(user);
        return "Username: "+ userName + " was deleted successfully.";
    }


    public UserViewModel editUser(UserViewModel userInput) {
        User user = userRepository.findByUsername(userInput.getUsername());
        user.setFirstName(userInput.getFirstName());
        user.setLastName(userInput.getLastName());
        user.setEmail(userInput.getEmail());
        user.setDepartment(userInput.getDepartment());
        user.setRoles(userInput.getRoles());
        user.setActive(userInput.isActive());

        return userToViewModel(userRepository.save(user));
    }


    //HELPER METHOD
    private UserViewModel userToViewModel(User user) {
        UserViewModel userViewModel = new UserViewModel();
        userViewModel.setId(user.getId());
        userViewModel.setUsername(user.getUsername());
        userViewModel.setFirstName(user.getFirstName());
        userViewModel.setLastName(user.getLastName());
        userViewModel.setEmail(user.getEmail());
        userViewModel.setDepartment(user.getDepartment());
        userViewModel.setActive(user.isActive());
        userViewModel.setRoles(user.getRoles());
        return userViewModel;
    }

}
