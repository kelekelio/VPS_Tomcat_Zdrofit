package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.repository;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.ClubWhoIsInCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubWhoIsInCountRepository extends JpaRepository<ClubWhoIsInCount, Long> {

    List<ClubWhoIsInCount> findAllByClubIdOrderByDate(Long id);
}
