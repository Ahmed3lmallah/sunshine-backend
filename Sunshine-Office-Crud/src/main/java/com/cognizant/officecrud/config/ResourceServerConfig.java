package com.cognizant.officecrud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers(HttpMethod.GET,"/offices").authenticated()
//                .antMatchers(HttpMethod.GET,"/offices/office/{id}").authenticated()
                .antMatchers(HttpMethod.POST,"/offices").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT,"/offices/office/{id}").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE,"/offices/office/{id}").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated();//was .permitAll();

        // add this line to use H2 web console
//        http.headers().frameOptions().disable();
    }
}