package com.example.gym.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping()
@RequiredArgsConstructor
public class PricingController { // 갤러리 페이지 연결

    @GetMapping("/pricing")
    public String gallery(){

        return "Main/pricing";
    }


}
