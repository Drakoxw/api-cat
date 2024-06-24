package com.dev.api_cat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

}
