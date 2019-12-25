package com.cognizant.SunshineAuthService.endpoint;

import com.cognizant.SunshineAuthService.model.User;
import com.cognizant.SunshineAuthService.service.UserService;
import com.cognizant.SunshineAuthService.views.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserViewModel> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/manager/{managerId}")
    public List<UserViewModel> getAllUsersByManagerId(@PathVariable Long managerId) {
        return userService.findUsersByManagerId(managerId);
    }

    @GetMapping("/users/{username}")
    public UserViewModel getUserByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @PostMapping("/users/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserViewModel publicRegister(@RequestBody User user) throws IllegalArgumentException{

        /*
        Security layer:
            Public registration shouldn't assign roles
         */
        if(user.getRole() != null) {
            throw new IllegalArgumentException("Public are not allowed to assign roles!!");
        }

        return userService.register(user);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserViewModel adminRegister(@RequestBody User user) throws IllegalArgumentException{

        /*
        Validation Step:
            Admin registration should include proper role objects with ids
         */
        if(user.getRole() == null) {
            throw new IllegalArgumentException("Admin should assign roles!!");
        } else if(user.getRole().getId() == null) {
            throw new IllegalArgumentException("Roles should include IDs!!");
        }

        return userService.register(user);
    }

    @DeleteMapping("/users/{username}")
    public String deleteUser(@PathVariable String username){
        return userService.deleteUserByUsername(username);
    }

    @PutMapping("users/{username}")
    public UserViewModel updateUser(@RequestBody UserViewModel userInput, @PathVariable String username) throws IllegalArgumentException{
        if(!username.equals(userInput.getUsername())){
            throw new IllegalArgumentException("No match found!");
        }

        if(userInput.getRole() == null) {
            throw new IllegalArgumentException("Admin should assign roles!!");
        } else if (userInput.getRole().getId() == null) {
            throw new IllegalArgumentException("Roles should include IDs!!");
        }
        return userService.editUser(userInput);
    }
}
