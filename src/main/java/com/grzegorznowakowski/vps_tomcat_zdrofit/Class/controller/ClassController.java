package com.grzegorznowakowski.vps_tomcat_zdrofit.Class.controller;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Class.service.ClassService;
import com.grzegorznowakowski.vps_tomcat_zdrofit.dto.MonikaDTO;
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

    @RequestMapping({"/"})
    public String getMonika(Model model) {
        model.addAttribute("monika", classService.getMonika());
        return "index";
    }
}
