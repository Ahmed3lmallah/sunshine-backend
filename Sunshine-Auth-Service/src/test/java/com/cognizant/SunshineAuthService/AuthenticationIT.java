package com.cognizant.SunshineAuthService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class AuthenticationIT {

    @Autowired
    MockMvc mvc;

    @Value("${security.oauth2.client.client-id}")
    String clientId;

    @Value("${security.oauth2.client.client-secret}")
    String clientSecret;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void testGetToken() throws Exception {
        //invoke the token url and receive a token in return
        MvcResult result = mvc.perform(post("/oauth/token")
            .with(httpBasic(clientId,clientSecret))
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .content("grant_type=password&username=test&password=test"))
            .andExpect(status().isOk()).andReturn();
        String tokenString = result.getResponse().getContentAsString();
        //map
        Map<String,Object> map = mapper.readValue(tokenString,new TypeReference<Map<String,Object>>() {});
        assertTrue(map.containsKey("access_token"));
    }

    @Test
    public void testCheckToken() throws Exception {
        //invoke the token url and receive a token in return
        MvcResult result = mvc.perform(post("/oauth/token")
            .with(httpBasic(clientId,clientSecret))
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .content("grant_type=password&username=test&password=test"))
            .andExpect(status().isOk()).andReturn();
        String tokenString = result.getResponse().getContentAsString();
        //map
        Map<String,Object> map = mapper.readValue(tokenString,new TypeReference<Map<String,Object>>() {});
        //Check token
        result = mvc.perform(post("/oauth/check_token")
            .with(httpBasic(clientId,clientSecret))
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .content("token="+map.get("access_token")))
            .andExpect(status().isOk()).andReturn();
        tokenString = result.getResponse().getContentAsString();
        map = mapper.readValue(tokenString,new TypeReference<Map<String,Object>>() {});
        assertTrue(map.containsKey("user_name"));
    }

    @Test
    public void testCheckMe() throws Exception {
        //invoke the token url and receive a token in return
        MvcResult result = mvc.perform(post("/oauth/token")
            .with(httpBasic(clientId,clientSecret))
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .content("grant_type=password&username=test&password=test"))
            .andExpect(status().isOk()).andReturn();
        String tokenString = result.getResponse().getContentAsString();
        //map
        Map<String,Object> map = mapper.readValue(tokenString,new TypeReference<Map<String,Object>>() {});
        //Check token
        result = mvc.perform(get("/user/me")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .header("Authorization","Bearer "+map.get("access_token")))
            .andExpect(status().isOk()).andReturn();
        tokenString = result.getResponse().getContentAsString();
        map = mapper.readValue(tokenString,new TypeReference<Map<String,Object>>() {});
        assertTrue(map.containsKey("username"));
    }

    @Test
    public void testEncrypt() throws Exception {
        //invoke the token url and receive a token in return
        MvcResult result = mvc.perform(post("/oauth/token")
            .with(httpBasic(clientId,clientSecret))
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .content("grant_type=password&username=test&password=test"))
            .andExpect(status().isOk()).andReturn();
        String tokenString = result.getResponse().getContentAsString();
        //map
        Map<String,Object> map = mapper.readValue(tokenString,new TypeReference<Map<String,Object>>() {});
        //invoke the token url and receive a token in return
        result = mvc.perform(post("/encrypt")
            .header("Authorization","Bearer "+map.get("access_token"))
            .contentType(MediaType.TEXT_PLAIN)
            .content("test"))
            .andExpect(status().isOk()).andReturn();
        String encryptedPassword = result.getResponse().getContentAsString();
        assertNotNull(encryptedPassword);
    }

}
