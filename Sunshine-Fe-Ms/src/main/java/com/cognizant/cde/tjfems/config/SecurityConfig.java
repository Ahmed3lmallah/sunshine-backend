package com.cognizant.cde.tjfems.config;

import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthoritiesExtractor customAuthoritiesExtractor() {
        return new CustomAuthoritiesExtractor();
    }

    @Bean
    public RequestInterceptor requestTokenBearerInterceptor() {
        return new CustomRequestInterceptor();
    }
}
