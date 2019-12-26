package com.cognizant.cde.tjfems.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // Protected Office Crud Endpoints
                .antMatchers(HttpMethod.POST,"/api/offices").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/offices/{id}").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/offices/{id}").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET,"/api/offices/manager").hasAuthority("ROLE_MANAGER")
                // Protected Equipment CRUD Endpoints
                .antMatchers(HttpMethod.POST, "/api/equipment").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/equipment/{id}").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/equipment/{id}").hasAuthority("ROLE_ADMIN")
                // Protected User Crud Endpoints
                .antMatchers("/api/users/register").permitAll()
                .antMatchers(HttpMethod.POST,"/api/users").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/users/{username}").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/users/{username}").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET,"/api/users/manager").hasAuthority("ROLE_MANAGER")
                // All Others
                .anyRequest().authenticated();
    }
}