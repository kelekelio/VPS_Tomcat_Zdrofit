package com.grzegorznowakowski.vps_tomcat_zdrofit.Class.repository;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Class.entity.ClassWhoIsIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassWhoIsInRepository extends JpaRepository<ClassWhoIsIn, Long> {

}
