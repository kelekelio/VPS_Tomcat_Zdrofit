package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.service;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.Enum.ChartType;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto.Count;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto.ChartResponse;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto.ClubCountResponse;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.Club;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.ClubWhoIsInCount;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.repository.ClubRepository;
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
    private final ClubRepository clubRepository;

    public List<Club> listAllClubs() {
        return clubRepository.findAll();
    }

    public List<Count> listLogsForClubById(Long id, LocalDate day) {
        return clubWhoIsInCountRepository.findAllForClubAndDay(id, day.atStartOfDay(), day.plusDays(1).atStartOfDay());
    }

    public List<Count> getAverage(Long clubId, LocalDate day) {
        return clubWhoIsInCountRepository.getAverageFor(clubId, day.atStartOfDay());
    }

    //todo decide
    public ChartResponse getAverageCountForClub(Long clubId, LocalDate day) {
        return ChartResponse.builder()
                .name("Average")
                .type(ChartType.SPLINE.type)
                .markerSize(5)
                .xValueFormatString("HH:mm")
                .yValueFormatString("#,##0.##")
                .color("rgba(102, 0, 255,.7)")
                .showInLegend(Boolean.TRUE)
                .visible(Boolean.TRUE)
                .dataPoints(clubWhoIsInCountRepository.getAverageFor(clubId, day.atStartOfDay()))
                .build();
    }
}
