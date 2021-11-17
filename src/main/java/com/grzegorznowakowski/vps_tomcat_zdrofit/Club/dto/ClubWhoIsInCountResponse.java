package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grzegorznowakowski.vps_tomcat_zdrofit.dto.ApiResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ClubWhoIsInCountResponse extends ApiResponse {

    private List<ClubWhoIsInCountDTO> data;

    @Builder
    public ClubWhoIsInCountResponse(@JsonProperty("errors") String errors,
                                    @JsonProperty("data") List<ClubWhoIsInCountDTO> data) {
        super(errors);
        this.data = data;
    }
}
