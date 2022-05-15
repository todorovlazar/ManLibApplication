package com.example.seminarskawp.manlib.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/pocetna"})
    public String showIndexPage(){
        return "index";
    }

    @GetMapping("/zanas")
    public String showAboutPage(){
        return "about";
    }
}
