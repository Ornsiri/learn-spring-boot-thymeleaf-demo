package com.ornsiri.springboot.thymeleafdemo.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public  String letsShoutDude(HttpServletRequest request, Model model) {
        // read data from parameter
        String name = request.getParameter("studentName").toUpperCase();
        // convert to upper case
        name = name.toUpperCase();
        // create a message
        String result = "Yo! " + name;
        // add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public  String processFormVersionThree(@RequestParam("studentName") String name, Model model) {
        // convert to upper case
        name = name.toUpperCase();
        // create a message
        String result = "Yo Yo from v3! " + name;
        // add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }


}
