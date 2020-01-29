package com.nga.springboot.springbootthymeleaf.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    // create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model model) {

        model.addAttribute("date", new java.util.Date());

        return "helloworld";

    }

}
