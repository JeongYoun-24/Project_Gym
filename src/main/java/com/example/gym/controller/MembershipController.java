package com.example.gym.controller;

import com.example.gym.dto.MemberDTO;
import com.example.gym.dto.MembershipDTO;
import com.example.gym.dto.ShipHistoryDTO;
import com.example.gym.entity.ShipHistory;
import com.example.gym.repository.ShipHistoryRepository;
import com.example.gym.service.member.MemberService;
import com.example.gym.service.membership.MembershipService;
import com.example.gym.service.shipHistory.ShipHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashMap;

@Log4j2
@Controller
@RequestMapping()
@RequiredArgsConstructor
public class MembershipController { // 갤러리 페이지 연결


    private final MembershipService membershipService;
    private final MemberService memberService;
    private final ShipHistoryService shipHistoryService;
    private final ShipHistoryRepository shipHistoryRepository;


    @GetMapping("/membership") // 회원권 페이지만 보기
    public String gallery(){

        return "Main/pricing";
    }
    @GetMapping("/ship/{shipNo}") // 회원권 상세 페이지
    public String ship(@PathVariable("shipNo")String shipNo, Model model){
        log.info("클라이언트로부터 받은 값 ======"+shipNo);

        Long membershipNo = Long.parseLong(shipNo);

        MembershipDTO membershipDTO =membershipService.readOne(membershipNo);

        log.info("서비스로부터 받은 DTO 값 ====="+membershipDTO );

        model.addAttribute("membershipDTO",membershipDTO);



        return "membership/ship";
    }

    @ResponseBody   // 회원권 결제 ajax 처리
    @RequestMapping(value = "/ship",method = {RequestMethod.POST}, produces="application/json;charset=UTF-8")
    public ResponseEntity Postship(@RequestBody HashMap<String,Object> map,Model model,Principal principal) {

        log.info("클라이언트로부터 받은 값 ======" + map);

        String shipNo = (String) map.get("shipNo");

        Long membershipNo = Long.parseLong(shipNo);

        log.info("받은값 전환 ====" + membershipNo);
       MembershipDTO membershipDTO =  membershipService.readOne(membershipNo);


        if (principal == null) {

            return new ResponseEntity<String>("로그인 필수", HttpStatus.BAD_REQUEST);
        }
      String name = principal.getName();
            log.info(name);
         MemberDTO memberDTO = memberService.readOne(name);
            log.info(memberDTO);


        ShipHistory shipHistory  = shipHistoryRepository.findByMembership_MembershipNo(membershipNo);

        if(shipHistory.getMembership().getMembershipNo() == membershipDTO.getMembershipNo()){

            return new ResponseEntity<String>("결제실패", HttpStatus.BAD_REQUEST);
        }


        try{
            // 결제 내역 저장
            ShipHistoryDTO shipHistoryDTO  =   ShipHistoryDTO.builder()
                    .memberId(memberDTO.getMemberId())
                    .membershipNo(membershipDTO.getMembershipNo())
                    .price(membershipDTO.getPrice())
                    .months(membershipDTO.getMonths())
                    .shipDate(LocalDateTime.now())
                    .build();

          Long shipNo2 = shipHistoryService.register(shipHistoryDTO);

            memberDTO.setMemberShipCheck("on");
            memberService.shipModify(memberDTO);


        }catch (Exception e){
            model.addAttribute("errorMessage","영화 수정 중 에러가 발생했습니다.");
            return new ResponseEntity<String>("결제실패", HttpStatus.BAD_REQUEST);
        }



        return new ResponseEntity<String>("결제완료", HttpStatus.OK);
    }




    @ResponseBody   // 회원권 개월수 확인
    @RequestMapping(value = "/poship",method = {RequestMethod.POST}, produces="application/json;charset=UTF-8")
    public MembershipDTO posterJson(@RequestBody HashMap<String,Object> map, Model model){
        log.info("클라이언트로부터 받은 Ajax =="+map);


        String shipNo = (String) map.get("shipNo");



        Long membershipNo = Long.parseLong(shipNo);

        MembershipDTO membershipDTO =membershipService.readOne(membershipNo);


        return  membershipDTO;
    }




    @GetMapping("/shipRegister") // 회원권 등록 페이지
    public String shipRegister(){



        return "membership/shipRegister";
    }




}
