package com.cognizant.equipmentcrud.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.*;

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
            authorities.add(entry.get("name"));
        }
        return String.join(",", authorities);
    }
}