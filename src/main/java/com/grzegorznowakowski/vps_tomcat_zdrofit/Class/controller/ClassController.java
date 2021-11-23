package com.grzegorznowakowski.vps_tomcat_zdrofit.Class.controller;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Class.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Grzegorz Nowakowski
 */
@Controller
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    @RequestMapping(value = {"/classes"})
    public String listMembersRegisteredForClasses(Model model) {

        return "classes";
    }


}
