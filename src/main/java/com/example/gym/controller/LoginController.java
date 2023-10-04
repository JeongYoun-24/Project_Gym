package com.example.gym.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class LoginController {

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginGET(String error, String logout,Model model){
        log.info("logout =  "+logout);
//        if(logout != null){
//            log.info("user logout");
//        }
        model.addAttribute("loginErrorMsg","아이디 또는 비밀번호가 잘못됏슴다");

        return "login/login";
    }
    @GetMapping("/logout")
    public String logoutGet(){

        return "redirect :/login/login?logout";
    }


    @GetMapping("/login/error")
    public String loginerror(Model model){

        model.addAttribute("loginErrorMsg","아이디 또는 비밀번호가 잘못됏슴다");
        return "login/login";
    }





}
