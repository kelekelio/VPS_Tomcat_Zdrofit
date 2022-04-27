package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.ClubWhoIsInCount;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Value
public class ClubCountResponse {
    LocalDateTime x;
    Integer y;

    public static ClubCountResponse from(ClubWhoIsInCount clubWhoIsInCount) {
        return ClubCountResponse.builder()
                .x(clubWhoIsInCount.getDate())
                .y(clubWhoIsInCount.getCount())
                .build();
    }

    public static List<ClubCountResponse> fromList(List<ClubWhoIsInCount> clubWhoIsInCounts) {
        return clubWhoIsInCounts.stream()
                .map(ClubCountResponse::from)
                .collect(Collectors.toList());
    }
}
