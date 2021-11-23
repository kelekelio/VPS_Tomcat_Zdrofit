package com.grzegorznowakowski.vps_tomcat_zdrofit.Class.api;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Class.entity.ClassWhoIsIn;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Class.repository.ClassWhoIsInDataTablesRepository;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Class.repository.ClassWhoIsInRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Grzegorz Nowakowski
 */
@RestController
@RequiredArgsConstructor
public class ClassDataTablesController {

    private final ClassWhoIsInDataTablesRepository classWhoIsInRepository;

    @RequestMapping(value = {"/classes/ajax"}, method = RequestMethod.GET)
    public DataTablesOutput<ClassWhoIsIn> listRegisteredMembers(@Valid DataTablesInput input) {

        DataTablesOutput<ClassWhoIsIn> data = classWhoIsInRepository.findAll(input);
        return data;
    }

}
