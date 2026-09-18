package com.dusthakarmonika.minicommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{
    @GetMapping("/")
    public String home(){
        return "Mini E-Commerce Backend is running!";
    }
    }