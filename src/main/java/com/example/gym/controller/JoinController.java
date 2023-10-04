package com.example.gym.controller;

import com.example.gym.dto.MemberDTO;
import com.example.gym.entity.Member;
import com.example.gym.service.member.MemberJoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
@Log4j2
@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class JoinController {

    private final MemberJoinService memberJoinService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/join")  // 회원 가입 페이지
    public String joinpage(Model model){
        model.addAttribute("memberDTO", new MemberDTO());

        return "login/join";
    }

    @PostMapping(value="/join")
    public String saveMember(@Valid MemberDTO memberDTO, BindingResult bindingResult, Model model){
        log.info("--- member post");

        if (bindingResult.hasErrors()){
            return "login/join";
        }
        log.info(memberDTO);


        try {
//            usersDTO.setPassword(password);
//
//            usersService.pwdUpdate(usersDTO);

            Member member = Member.createMember(memberDTO, passwordEncoder);
            member.setRegDate(LocalDateTime.now());
            log.info("회원가입 값"+member);

            memberJoinService.saveUsers(member);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "login/join";
        }


        return "redirect:/member/login";
    }


}

