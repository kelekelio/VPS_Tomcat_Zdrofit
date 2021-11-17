package com.grzegorznowakowski.vps_tomcat_zdrofit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApiResponse {

    private String errors;

    public ApiResponse(@JsonProperty("errors") String errors) {
        this.errors = errors;
    }
}
