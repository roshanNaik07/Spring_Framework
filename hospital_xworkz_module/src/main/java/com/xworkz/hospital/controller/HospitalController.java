package com.xworkz.hospital.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/")
public class HospitalController {

    public HospitalController() {
        log.info("Running HospitalController");
    }

    @RequestMapping("/index")
    public String openIndexPage() {
        log.info("Running openIndexPage in HospitalController");
        return "index";
    }

}
