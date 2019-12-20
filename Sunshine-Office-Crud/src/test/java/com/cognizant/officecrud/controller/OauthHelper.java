package com.cognizant.officecrud.controller;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.util.JacksonJsonParser;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class OauthHelper {

    private static final String CLIENT_ID = "ClientId";
    private static final String CLIENT_SECRET = "ClientSecret";
    private static final String URL = "https://sunshine-auth-service.cfapps.io/oauth/token";

    public String getAccessToken(String username, String password){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> request = getRequest(username, password);
        ResponseEntity<String> entity = restTemplate.postForEntity( URL, request, String.class);

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(entity.getBody()).get("access_token").toString();
    }

    private HttpEntity<Object> getRequest(String username, String password){
        // Setting Headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + getBase64Credentials(CLIENT_ID, CLIENT_SECRET));
        // Setting Body
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("grant_type", "password");
        body.add("username", username);
        body.add("password", password);
        // Returning Http Entity
        return new HttpEntity<Object>(body, headers);
    }

    private String getBase64Credentials(String clientId, String clientSecret){
        String plainCreds = clientId + ":" + clientSecret;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }
}
