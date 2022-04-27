package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.repository;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.ClubWhoIsInCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ClubWhoIsInCountRepository extends JpaRepository<ClubWhoIsInCount, Long> {

    @Query("select c from ClubWhoIsInCount c " +
            "where c.clubId = :id " +
            "and c.date >= :start " +
            "and c.date < :end " +
            "order by c.date ")
    List<ClubWhoIsInCount> findAllForClubAndDay(Long id, LocalDateTime start, LocalDateTime end);
}
