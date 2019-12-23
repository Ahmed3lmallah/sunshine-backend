package com.cognizant.SunshineAuthService.config;

import com.cognizant.SunshineAuthService.model.Role;
import com.cognizant.SunshineAuthService.model.RoleName;
import com.cognizant.SunshineAuthService.repository.RoleRepository;
import com.cognizant.SunshineAuthService.repository.UserRepository;
import com.cognizant.SunshineAuthService.service.AuthService;
import com.cognizant.SunshineAuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitialLoader {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService registrationService;


    @PostConstruct
    private void defaultData() {
        createRoles();
        if (userRepository.count() <= 0) {
            registrationService.register("admin", "admin", Boolean.FALSE, RoleName.ROLE_ADMIN.name(), RoleName.ROLE_MANAGER.name(), RoleName.ROLE_DEVELOPER.name());
            registrationService.register("manager", "manager", Boolean.FALSE, RoleName.ROLE_MANAGER.name(), RoleName.ROLE_DEVELOPER.name());
            registrationService.register("developer", "developer", Boolean.FALSE);
            registrationService.register("test", "test", Boolean.FALSE);
        }
    }

    private void createRoles() {
        //check
        if (roleRepository.count() <= 0) {
            //init
            List<Role> roles = new ArrayList<>();
            //create the roles
            for (RoleName roleName : RoleName.values()) {
                Role role = new Role();
                role.setName(roleName.name());
                roles.add(role);
            }//end for
            //save
            roleRepository.saveAll(roles);
        }//end if
    }

}
