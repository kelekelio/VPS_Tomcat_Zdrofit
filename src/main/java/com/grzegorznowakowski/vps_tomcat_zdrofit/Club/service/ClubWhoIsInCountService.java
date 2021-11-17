package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.service;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto.ClubWhoIsInCountDTO;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto.ClubWhoIsInCountResponse;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.ClubWhoIsInCount;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.repository.ClubWhoIsInCountRepository;
import com.grzegorznowakowski.vps_tomcat_zdrofit.config.ZdrofitAPI;
import com.grzegorznowakowski.vps_tomcat_zdrofit.utils.HttpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubWhoIsInCountService {

    private final RestTemplate restTemplate;
    private final ClubWhoIsInCountRepository clubWhoIsInCountRepository;
    private final ZdrofitAPI zdrofitAPI;
    private final static String WHO_IS_IN_COUNT_URL = "/v1/Clubs/WhoIsInCount";

    public List<ClubWhoIsInCount> getAll() {
        return clubWhoIsInCountRepository.findAll();
    }

    public void logZdrofitMembers() {
        UriComponents uri = UriComponentsBuilder.fromUriString(zdrofitAPI.getUrl())
                .path(WHO_IS_IN_COUNT_URL)
                .build().encode();

        ResponseEntity<ClubWhoIsInCountResponse> response = restTemplate.exchange(uri.toString(),
                HttpMethod.GET,
                zdrofitAPI.getHttpEntity(),
                ClubWhoIsInCountResponse.class);

        HttpUtils.validateError(response);
        saveWhoIsInCount(response);
    }

    private void saveWhoIsInCount(ResponseEntity<ClubWhoIsInCountResponse> response) {
        LocalDateTime time = LocalDateTime.now();
        Objects.requireNonNull(response.getBody()).getData().forEach(whoIsInCount -> logWhoIsIn(time, whoIsInCount));
    }

    private void logWhoIsIn(LocalDateTime time, ClubWhoIsInCountDTO whoIsInCount) {
        ClubWhoIsInCount logWhoIsIn = ClubWhoIsInCount.builder()
                .clubId(whoIsInCount.getClubId())
                .count(whoIsInCount.getCount())
                .date(time)
                .build();
        System.out.println(logWhoIsIn.getClubId() + " => " + whoIsInCount.getCount());

        clubWhoIsInCountRepository.save(logWhoIsIn);
    }
}
