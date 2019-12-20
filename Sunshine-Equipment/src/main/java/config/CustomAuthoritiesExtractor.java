package config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;

public class CustomAuthoritiesExtractor implements AuthoritiesExtractor {
    @Override
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
