package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.ClubWhoIsInCount;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class CountResponse {
    private Double y;
    private String x;

    public static List<CountResponse> from(List<ClubWhoIsInCount> clubWhoIsInCount) {
        return clubWhoIsInCount.stream()
                .map(CountResponse::from)
                .collect(Collectors.toList());
    }

    private static CountResponse from(ClubWhoIsInCount clubWhoIsInCount) {
        return CountResponse.builder()
                .y(clubWhoIsInCount.getCount().doubleValue())
                .x(clubWhoIsInCount.getDate().toString())
                .build();
    }
}
