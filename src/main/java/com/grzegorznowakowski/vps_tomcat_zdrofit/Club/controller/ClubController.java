package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.controller;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto.Count;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto.ChartResponse;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto.ClubCountResponse;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.Club;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.ClubWhoIsInCount;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.service.ClubService;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.service.ClubWhoIsInCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clubs")
public class ClubController {

    private final ClubWhoIsInCountService clubWhoIsInCountService;
    private final ClubService clubService;

    @GetMapping
    public List<Club> getAll() {
        return clubService.listAllClubs();
    }

    @GetMapping("/WhoIsInCount/all")
    public List<ClubWhoIsInCount> getAllSaved() {
        return clubWhoIsInCountService.getAll();
    }

    @GetMapping("/WhoIsInCount/{id}/{day}")
    public List<Count> getAllById(@PathVariable(name = "id") Long id, @PathVariable(name = "day") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate day) {
        return clubService.listLogsForClubById(id, day);
    }

    @GetMapping("/average/{id}/{day}")
    public List<Count> getAverageCount(@PathVariable(name = "id") Long id, @PathVariable(name = "day") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate day) {
        return clubService.getAverage(id, day);
    }

    @GetMapping("/count/average/{id}/{day}")
    public ChartResponse getCountForClub(@PathVariable(name = "id") Long id, @PathVariable(name = "day") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate day) {
        return clubService.getAverageCountForClub(id, day);
    }
}
