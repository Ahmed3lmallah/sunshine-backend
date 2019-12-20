package com.cognizant.equipmentcrud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/equipment").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, "/equipment/{id}").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/equipment/{id}").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated();
    }
}
