package com.cognizant.SunshineAuthService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users/register").permitAll()
                .antMatchers(HttpMethod.POST,"/users").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/users/{username}").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, "/users/{username}").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated();
    }
}