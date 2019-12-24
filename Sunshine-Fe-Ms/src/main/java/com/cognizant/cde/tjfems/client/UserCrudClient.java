package com.cognizant.cde.tjfems.client;

import com.cognizant.cde.tjfems.model.User;
import com.cognizant.cde.tjfems.model.UserViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="sunshine-auth-server", url="https://sunshine-auth-service.cfapps.io/")
public interface UserCrudClient {

    @GetMapping("/users")
    List<UserViewModel> getAllUsers();

    @GetMapping("/users/manager/{managerId}")
    List<UserViewModel> getAllUsersByManagerId(@PathVariable(name = "managerId") Long managerId);

    @GetMapping("/users/{username}")
    UserViewModel getUserByUsername(@PathVariable(name = "username") String username);

    @PostMapping("/users/register")
    UserViewModel publicRegister(@RequestBody User user);

    @PostMapping("/users")
    UserViewModel adminRegister(@RequestBody User user);

    @DeleteMapping("/users/{username}")
    String deleteUser(@PathVariable(name = "username") String username);

    @PutMapping("users/{username}")
    UserViewModel updateUser(@RequestBody UserViewModel userInput, @PathVariable(name = "username") String username);
}
