package com.grzegorznowakowski.vps_tomcat_zdrofit.Class.repository;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Class.entity.ClassWhoIsIn;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Grzegorz Nowakowski
 */
public interface ClassWhoIsInDataTablesRepository extends DataTablesRepository<ClassWhoIsIn, Long> {

}
