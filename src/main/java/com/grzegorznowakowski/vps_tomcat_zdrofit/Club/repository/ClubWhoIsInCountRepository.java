package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.repository;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto.Count;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.ClubWhoIsInCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ClubWhoIsInCountRepository extends JpaRepository<ClubWhoIsInCount, Long> {

    @Query("SELECT c.count AS y, CONCAT(c.date) AS x " +
            "FROM ClubWhoIsInCount c " +
            "WHERE c.clubId = :id " +
            "AND c.date >= :start " +
            "AND c.date < :end " +
            "ORDER BY c.date ")
    List<Count> findAllForClubAndDay(Long id, LocalDateTime start, LocalDateTime end);

    @Query(value = "SELECT FLOOR(AVG(c.count)) AS y, CONCAT(DATE_FORMAT(:date,'%Y-%m-%d'), ' ', DATE_FORMAT(c.date,'%H:%i')) AS x " +
            "FROM ClubWhoIsInCount c " +
            "WHERE c.clubId  = :clubId " +
            "AND weekday(c.date) = weekday(:date) " +
            "GROUP BY x")
    List<Count> getAverageFor(Long clubId, LocalDateTime date);

}
