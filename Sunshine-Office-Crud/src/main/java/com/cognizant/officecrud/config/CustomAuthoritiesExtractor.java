package com.cognizant.officecrud.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// This file is only needed if custom principle is used.
public class CustomAuthoritiesExtractor implements AuthoritiesExtractor {

    @Override
    public List<GrantedAuthority> extractAuthorities (Map<String, Object> map) {
        return AuthorityUtils
                .commaSeparatedStringToAuthorityList(asAuthorities(map));
    }

    private String asAuthorities(Map<String, Object> map) {
        List<String> authorities = new ArrayList<>();
        List<LinkedHashMap<String, String>> authz =
                (List<LinkedHashMap<String, String>>) map.get("roles");

        for (LinkedHashMap<String, String> entry : authz) {
            authorities.add("ROLE_"+entry.get("name"));
        }
        return String.join(",", authorities);
    }
}