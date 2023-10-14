package com.example.gym.controller;

import com.example.gym.dto.RankDTO;
import com.example.gym.dto.TeacherDTO;
import com.example.gym.service.rank.RankService;
import com.example.gym.service.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping()
@RequiredArgsConstructor
public class RegisterController {

    private final RankService rankService;
    private final TeacherService teacherService;


    @GetMapping(value = "/admin/rank")  // 직급 등록 페이지
    public String getrank(Model model){
        log.info("직급 등록 페이지 ");
        model.addAttribute("rankDTO", new RankDTO());

        return "register/rank";
    }


    // 직급 등록 페이지
    @PostMapping(value ="/admin/rank")
    public String postRank(@Valid RankDTO rankDTO, BindingResult bindingResult, Model model ){

        log.info("클라이언트에서 받은 정보 값 "+rankDTO);

        if (bindingResult.hasErrors()){

            return "register/rank";
        }

        try {
            log.info("클라이언트에서 받은 정보값"+rankDTO);
            Long rankno = rankService.register(rankDTO);

            model.addAttribute("Message",rankno+"번 직급 등록완료");

        }catch (Exception e){
            model.addAttribute("errorMessage","직급 등록 중 에러가 발생하였습니다.");
            return "register/rank";
        }

//        redirect   ↓ 성공시 이동 경로
        return "redirect:/main";
    }

    // 직급 수정 페이지
    @GetMapping(value = "/admin/rank/modify/{rankNo}")
    public String rankmodify(@PathVariable("rankNo") Long rankNo, Model model){
        log.info("아이디값 찾기 "+rankNo);

        try{
            RankDTO rankDTO = rankService.readOne(rankNo);  // 아이디값으로  정보 조회

            log.info("아이디값 찾기 "+rankDTO);
//            boardImgService.

            model.addAttribute("rankDTO",rankDTO);

        }catch (EntityNotFoundException e){

            model.addAttribute("errorMessage","존재하지 않는 상품입니다.");
            model.addAttribute("rankDTO", new RankDTO());

            return "register/rank";
        }

        return "register/rank";
    }

    // 직급 정보 수정
    @PostMapping(value="/admin/rank/modify/{rankNo}")
    public String rankUpdate(@Valid RankDTO rankDTO,Long rankNo, BindingResult bindingResult, Model model){
        log.info("수정 페이지  ㄱㄱㄱ ");
        log.info(rankDTO);


        // 데이터 검증 확인
        if (bindingResult.hasErrors()){
            return "register/rank";
        }

        // 정보 호출
        try{
            rankService.modify(rankDTO);
        }catch (Exception e){
            model.addAttribute("errorMessage","상품 수정 중 에러가 발생했습니다.");
            return "register/rank";
        }

        return "redirect:/main";
    }

    @PostMapping("/rank/delete") // 공지사항 삭제 +이미지
    public String boardDelete(HttpServletRequest req, RedirectAttributes redirectAttributes){
        log.info("값 들어왔니??");


        Long rankNo = (Long.parseLong(req.getParameter("id")));

//        Long id = Long.parseLong(rankNo);

        rankService.remove(rankNo);

        log.info("ㅅㄷㄳㅅㄷㄳ"+rankNo);


            try {

                redirectAttributes.addFlashAttribute("result", rankNo + "직급 정보 삭제 했습니다.");
                return "redirect:/main";
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("result", rankNo + " 직급 정보 삭제 실패 했습니다.");
                return "redirect:/main";
            }

    }


// <------------------------------------------------트레이너 등록------------------------------------------

    // 트레이너 아이디 등록 GET
    @GetMapping(value = "admin/teacher")
    public String GetHeaher(Model model){

        log.info("직급 등록 페이지 ");
        model.addAttribute("teacherDTO", new TeacherDTO());

        return "register/teacher";
    }

    // 트레이너 아이디 등록 POST
    @PostMapping(value = "admin/teacher")
    public String PostHeaher(@Valid TeacherDTO teacherDTO, BindingResult bindingResult, Model model){

        log.info("클라이언트에서 받은 정보 값 "+teacherDTO);

        if (bindingResult.hasErrors()){

            return "register/teacher";
        }

        try {
            log.info("클라이언트에서 받은 정보값"+teacherDTO);
            String employeeId = teacherService.register(teacherDTO);

            model.addAttribute("Message",employeeId+"아이디 등록완료");

        }catch (Exception e){
            model.addAttribute("errorMessage","직급 등록 중 에러가 발생하였습니다.");
            return "register/teacher";
        }

        return "register/teacher";
    }
    // 트레이너 아이디 조회 페이지


    // 트레이너 아이디 수정 GET
    // 트레이너 아이디 수정 POST
    // 트레이너 아이디 삭제 delete


    // 회원권 등록 GET
    @GetMapping(value = "admin/ship")
    public String Getship(){

        return "register/membership";
    }

    // 회원권 등록 POST
    // 회원권 조회
    // 회원권 수정 GET
    // 회원권 수정 POST






}
