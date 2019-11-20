package com.devsda.hack.alterego.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AlteregoConfiguration extends Configuration implements Serializable {

    @NotNull
    @JsonProperty("environment")
    private Environment environment;

    @NotNull
    @JsonProperty("applicationName")
    private String applicationName;

    @NotNull
    @JsonProperty("authToken")
    private String authToken;

    @NotNull
    @JsonProperty("apiKey")
    private String apiKey;

    @NotNull
    @JsonProperty("calendarId")
    private String calendarId;


    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = Environment.valueOf(environment);
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    @Override
    public String toString() {
        return "AlteregoConfiguration{" +
                "environment=" + environment +
                ", applicationName='" + applicationName + '\'' +
                ", authToken='" + authToken + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", calendarId='" + calendarId + '\'' +
                '}';
    }
}
