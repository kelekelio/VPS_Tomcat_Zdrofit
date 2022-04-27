package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.service;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto.ClubCountResponse;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.ClubWhoIsInCount;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.repository.ClubWhoIsInCountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubService {

    private final ClubWhoIsInCountRepository clubWhoIsInCountRepository;

    public List<ClubCountResponse> listLogsForClubById(Long id, LocalDate day) {
        return createResponse(clubWhoIsInCountRepository.findAllForClubAndDay(id, day.atStartOfDay(), day.plusDays(1).atStartOfDay()));
    }

    private List<ClubCountResponse> createResponse(List<ClubWhoIsInCount> clubWhoIsInCounts) {
        return ClubCountResponse.fromList(clubWhoIsInCounts);
    }
}
