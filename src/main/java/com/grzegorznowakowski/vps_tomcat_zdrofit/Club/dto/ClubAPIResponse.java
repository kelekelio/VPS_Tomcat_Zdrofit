package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grzegorznowakowski.vps_tomcat_zdrofit.dto.ApiResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ClubAPIResponse extends ApiResponse {

    private List<ClubDTO> data;

    @Builder
    public ClubAPIResponse(@JsonProperty("errors") String errors,
                                    @JsonProperty("data") List<ClubDTO> data) {
        super(errors);
        this.data = data;
    }
}
