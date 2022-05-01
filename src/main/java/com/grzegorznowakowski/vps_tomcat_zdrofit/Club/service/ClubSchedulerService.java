package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.service;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto.ClubAPIResponse;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto.ClubDTO;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto.ClubWhoIsInCountResponse;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.Club;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.repository.ClubRepository;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.repository.ClubWhoIsInCountRepository;
import com.grzegorznowakowski.vps_tomcat_zdrofit.config.ZdrofitAPI;
import com.grzegorznowakowski.vps_tomcat_zdrofit.utils.HttpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubSchedulerService {

    private final RestTemplate restTemplate;
    private final ClubRepository clubRepository;
    private final ZdrofitAPI zdrofitAPI;
    private final static String CLUBS = "/v1/Clubs/Clubs";

    public void logClubs() {
        UriComponents uri = UriComponentsBuilder.fromUriString(zdrofitAPI.getUrl())
                .path(CLUBS)
                .build().encode();
        log.info("Outgoing request:   endpoint: {} {}", HttpMethod.GET, uri);

        ResponseEntity<ClubAPIResponse> response = restTemplate.exchange(uri.toString(),
                HttpMethod.GET,
                zdrofitAPI.getHttpEntity(),
                ClubAPIResponse.class);

        HttpUtils.validateError(response);
        saveClubs(response);
    }

    private void saveClubs(ResponseEntity<ClubAPIResponse> response) {
        Objects.requireNonNull(response.getBody()).getData().forEach(this::logClub);
    }

    @Transactional
    public void logClub(ClubDTO clubDTO) {
        clubRepository.save(Club.builder()
                        .id(clubDTO.getId())
                        .name(clubDTO.getName())
                        .latitude(clubDTO.getLatitude())
                        .longitude(clubDTO.getLongitude())
                        .description(clubDTO.getDescription())
                        .companyId(clubDTO.getCompanyId())
                        .isDeleted(clubDTO.getIsDeleted() != null ? clubDTO.getIsDeleted() : false)
                        .isHidden(clubDTO.getIsHidden() != null ? clubDTO.getIsHidden() : false)
                .build());
    }
}
