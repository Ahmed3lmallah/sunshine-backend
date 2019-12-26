package com.cognizant.cde.tjfems.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;

@Entity
@Table(name="history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long entryId;
    @NotNull private LocalDateTime date;
    @NotNull private String service;
    @NotNull private String requestMethod;
    @NotNull private String requestEndpoint;
    @NotNull private String username;
    @NotNull private String description;

    public History() {
    }

    public History(String service, String requestMethod, String requestEndpoint, String description) {
        this.service = service;
        this.requestMethod = requestMethod;
        this.requestEndpoint = requestEndpoint;
        this.description = description;

        // Setting Time
        this.date = LocalDateTime.now();

        // Getting username from Security Context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2Authentication castedAuthentication = (OAuth2Authentication) authentication;
        LinkedHashMap userInfo = (LinkedHashMap) castedAuthentication.getUserAuthentication().getDetails();
        this.username = userInfo.get("username").toString();
    }

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestEndpoint() {
        return requestEndpoint;
    }

    public void setRequestEndpoint(String requestEndpoint) {
        this.requestEndpoint = requestEndpoint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
