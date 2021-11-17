package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.controller;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.ClubWhoIsInCount;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.service.ClubWhoIsInCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clubs")
public class ClubController {

    private final ClubWhoIsInCountService clubWhoIsInCountService;

    @GetMapping("/WhoIsInCount/all")
    public List<ClubWhoIsInCount> getAllSaved() {
        return clubWhoIsInCountService.getAll();
    }
}