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
                .antMatchers(HttpMethod.POST,"/api/offices").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/offices/{id}").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/offices/{id}").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET,"/api/offices/manager").hasAuthority("ROLE_MANAGER")
//                .antMatchers(HttpMethod.GET,"/api/offices/{id}").authenticated()
//                .antMatchers(HttpMethod.GET,"/api/offices").authenticated()
                .anyRequest().authenticated();
    }
}