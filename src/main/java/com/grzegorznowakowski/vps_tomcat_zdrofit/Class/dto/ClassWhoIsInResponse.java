package com.grzegorznowakowski.vps_tomcat_zdrofit.Class.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grzegorznowakowski.vps_tomcat_zdrofit.dto.ApiResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ClassWhoIsInResponse extends ApiResponse {

    private List<ClassWhoIsInDTO> data;

    @Builder
    public ClassWhoIsInResponse(@JsonProperty("errors") String errors,
                                @JsonProperty("data") List<ClassWhoIsInDTO> data) {
        super(errors);
        this.data = data;
    }
}
