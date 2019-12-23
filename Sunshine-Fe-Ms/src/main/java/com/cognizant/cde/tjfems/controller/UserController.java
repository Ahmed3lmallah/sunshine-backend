package com.cognizant.cde.tjfems.controller;

import com.cognizant.cde.tjfems.client.UserCrudClient;
import com.cognizant.cde.tjfems.model.User;
import com.cognizant.cde.tjfems.model.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserCrudClient userCrudClient;

    @GetMapping
    public List<UserViewModel> getAllUsers() {
        return userCrudClient.getAllUsers();
    }

    @GetMapping("/{username}")
    public UserViewModel getUserByUsername(@PathVariable(name = "username") String username){
        return userCrudClient.getUserByUsername(username);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserViewModel publicRegister(@RequestBody User user) {
        return userCrudClient.publicRegister(user);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserViewModel adminRegister(@RequestBody User user) {
        return userCrudClient.adminRegister(user);
    }

    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable(name = "username") String username){
        return userCrudClient.deleteUser(username);
    }

    @PutMapping("/{username}")
    public UserViewModel updateUser(@RequestBody UserViewModel userInput, @PathVariable(name = "username") String username) {
        return userCrudClient.updateUser(userInput, username);
    }
}
