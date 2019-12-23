package com.cognizant.SunshineAuthService.endpoint;

import com.cognizant.SunshineAuthService.model.User;
import com.cognizant.SunshineAuthService.service.UserService;
import com.cognizant.SunshineAuthService.views.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<UserViewModel> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{username}")
    public UserViewModel getUserByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @PostMapping("/users/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserViewModel publicRegister(@RequestBody User user) throws Exception{

        /*
        Security layer:
            Public registration shouldn't assign roles
         */
        if(user.getRoles().size() != 0) {
            throw new IllegalArgumentException("Public are not allowed to assign roles!!");
        }

        return userService.register(user);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserViewModel adminRegister(@RequestBody User user) throws Exception{

        /*
        Validation Step:
            Admin registration should include proper role objects with ids
         */
        if(user.getRoles().size() == 0) {
            throw new IllegalArgumentException("Admin should assign roles!!");
        } else {
            AtomicBoolean isValid = new AtomicBoolean(true);
            user.getRoles().forEach(role -> {
                if(role.getId() == null) {
                    isValid.set(false);
                }
            });
            if(!isValid.get()){
                throw new IllegalArgumentException("Roles should include IDs!!");
            }
        }

        return userService.register(user);
    }

    @DeleteMapping("/users/{username}")
    public String deleteUser(@PathVariable String username){
        return userService.deleteUserByUsername(username);
    }

    @PutMapping("users/{username}")
    public UserViewModel updateUser(@RequestBody UserViewModel userInput, @PathVariable String username) throws Exception{
        if(!username.equals(userInput.getUsername())){
            throw new IllegalArgumentException("No match found!");
        }

        if(userInput.getRoles().size() == 0) {
            throw new IllegalArgumentException("Admin should assign roles!!");
        } else {
            AtomicBoolean isValid = new AtomicBoolean(true);
            userInput.getRoles().forEach(role -> {
                if(role.getId() == null) {
                    isValid.set(false);
                }
            });
            if(!isValid.get()){
                throw new IllegalArgumentException("Roles should include IDs!!");
            }
        }
        return userService.editUser(userInput);
    }
}
