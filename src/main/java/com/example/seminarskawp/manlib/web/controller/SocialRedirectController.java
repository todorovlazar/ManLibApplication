package com.example.seminarskawp.manlib.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SocialRedirectController {

    @RequestMapping("/facebookPage")
    public RedirectView facebookRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.facebook.com");
        return redirectView;
    }
    @RequestMapping("/instagramPage")
    public RedirectView instagramRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.instagram.com");
        return redirectView;
    }
    @RequestMapping("/linkedinPage")
    public RedirectView linkedinRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.linkedin.com");
        return redirectView;
    }
    @RequestMapping("/lazarLinkedin")
    public RedirectView lazarLinkedinRedirect(){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.linkedin.com/in/todorovlazar/");
        return redirectView;
    }
    @RequestMapping("/milaLinkedin")
    public RedirectView milaLinkedinRedirect(){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.linkedin.com/in/mila-trifunova/");
        return redirectView;
    }
}
