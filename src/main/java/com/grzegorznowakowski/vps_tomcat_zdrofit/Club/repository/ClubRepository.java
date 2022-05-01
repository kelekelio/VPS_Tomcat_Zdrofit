package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.repository;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
