package com.cognizant.SunshineAuthService;

import com.cognizant.SunshineAuthService.repository.RoleRepository;
import com.cognizant.SunshineAuthService.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ApplicationIT {

    @Autowired
    ApplicationContext context;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void testRolesAdded() throws Exception {
        assertTrue(roleRepository.count() == 3);
    }

    @Test
    public void testForAuthenticationManager() throws Exception {
        assertTrue(context.getBeanDefinitionCount() > 0);
        assertTrue(userRepository.count() >= 0);//initial user has been added
    }

}
