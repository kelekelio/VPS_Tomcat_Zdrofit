package com.grzegorznowakowski.vps_tomcat_zdrofit.Class.controller;

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

    @RequestMapping(value = {"/classes"})
    public String listMembersRegisteredForClasses(Model model) {
        return "classes";
    }


}
