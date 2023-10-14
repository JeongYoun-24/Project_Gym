package com.example.gym.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
public class ControllerTest {


    @GetMapping(value = "test")
    public String test(){

        return "Main/index";
    }

    @GetMapping(value = "test2")
    public String test2(){

        return "fragments/header";
    }
    @GetMapping(value = "test3")
    public String test3(){

        return "Main/test";
    }





}
