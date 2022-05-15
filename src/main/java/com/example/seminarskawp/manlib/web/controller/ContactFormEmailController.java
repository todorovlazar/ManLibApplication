package com.example.seminarskawp.manlib.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactFormEmailController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/kontaktirajNeNas")
    public String submitContactFormEmail(HttpServletRequest request){

        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        String mailContent = null;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email);
        message.setTo("lazar.todorov.biz@gmail.com");
        message.setSubject(subject);
        mailContent= "Следнава порака е испратена од "+fullname+" со е-маил адреса - "+email+"\n";
        mailContent+="--------------------------------------------------------------------------------------------------------------------------------------\n";
        mailContent+=content;
        message.setText(mailContent);

        mailSender.send(message);

        return "redirect:/";
    }
}
