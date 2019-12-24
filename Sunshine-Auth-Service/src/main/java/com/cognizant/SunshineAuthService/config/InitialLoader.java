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
            registrationService.register("admin", "admin", "Admin", "Strator", "admin@Cognizant.com", "CDE", 000000L, RoleName.ROLE_ADMIN.name(), RoleName.ROLE_MANAGER.name(), RoleName.ROLE_DEVELOPER.name());
            registrationService.register("manager", "manager", "Man", "Ager", "manager@Cognizant.com", "CDE", 000000L, RoleName.ROLE_MANAGER.name(), RoleName.ROLE_DEVELOPER.name());
            registrationService.register("developer", "developer", "Deve", "Loper", "developer@Cognizant.com", "CDE", 000000L);
            registrationService.register("test", "test", "Mr.", "Tester", "test@Cognizant.com", "CDE", 000000L);
            registrationService.register("291010", "password", "Manikandan", "Krishnamurthy", "Manikandan.KA@cognizant.com", "CDE", 000000L, RoleName.ROLE_MANAGER.name());
            registrationService.register("820120", "password", "Rebecca", "Anderson", "Rebecca.Anderson@cognizant.com", "CDE", 291010L);
            registrationService.register("833720", "password", "Arnab", "Chatterjee", "Arnab.Chatterjee6@cognizant.com", "CDE", 291010L);
            registrationService.register("820168", "password", "Xiaoyi", "Zhang", "Xiaoyi.Zhang@cognizant.com", "CDE", 291010L);
            registrationService.register("820122", "password", "Chitra", "Madhan", "Chitra.Madhan@cognizant.com", "CDE", 291010L);
            registrationService.register("820171", "password", "Edel", "Gonzalez", "Edel.Gonzalez@cognizant.com", "CDE", 291010L);
            registrationService.register("820171", "password", "Hyunseok", "Kahng", "Hyunseok.Kahng@cognizant.com", "CDE", 291010L);
            registrationService.register("820123", "password", "Sean", "Grano", "Sean.Grano@cognizant.com", "CDE", 291010L);
            registrationService.register("820118", "password", "William", "King", "William.King@cognizant.com", "CDE", 291010L);
            registrationService.register("831505", "password", "Ying", "Xiao", "Ying.Xiao@cognizant.com", "CDE", 291010L);
            registrationService.register("832469", "password", "Sudhir", "Yadunath", "Sudhir.Yadunath@cognizant.com", "CDE", 291010L);
            registrationService.register("820121", "password", "Ahmed", "Elmallah", "Ahmed.Elmallah@cognizant.com", "CDE", 291010L);
            registrationService.register("820161", "password", "Priti", "Solanki", "Priti.Solanki@cognizant.com", "CDE", 291010L);
            registrationService.register("835073", "password", "Hyun-Mo", "Kim", "Hyun-Mo.Kim@cognizant.com", "CDE", 291010L);

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
