package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class ClubWhoIsInCountDTO {

    private Integer count;
    private Long clubId;

    public ClubWhoIsInCountDTO(@JsonProperty("count") Integer count,
                           @JsonProperty("clubId") Long clubId) {
        this.count = count;
        this.clubId = clubId;
    }
}
