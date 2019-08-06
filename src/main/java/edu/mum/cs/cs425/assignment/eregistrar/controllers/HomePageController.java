package edu.mum.cs.cs425.assignment.eregistrar.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = "/eregistrar/home")
    public String displayHomePage(){

        return "home/index";
    }
}
