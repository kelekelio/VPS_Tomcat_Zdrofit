package com.grzegorznowakowski.vps_tomcat_zdrofit.Class.repository;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Class.entity.ClassWhoIsIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassWhoIsInRepository extends JpaRepository<ClassWhoIsIn, Long> {

    @Query("select c from ClassWhoIsIn c where (c.firstName like 'monika' and c.lastName like 'golly') or c.lastName like 'golly'")
    List<ClassWhoIsIn> findMonika();
}
