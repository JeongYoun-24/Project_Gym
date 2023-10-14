package com.example.gym.gym.RepositoryTest;

import com.example.gym.GymApplication;
import com.example.gym.constant.Role;
import com.example.gym.dto.MemberDTO;
import com.example.gym.entity.Member;
import com.example.gym.repository.MemberRepository;
import com.example.gym.service.member.LoginService;
import com.example.gym.service.member.MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@Log4j2
@AutoConfigureMockMvc
@SpringBootTest(classes = GymApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class MemberTest {


    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberService memberService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private MockMvc mockMvc;


    public Member createMember(){
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setMemberId("ccc");
        memberDTO.setPassword("1234");
        memberDTO.setName("크로스");
        memberDTO.setEmail("ccc@naver.com");
        memberDTO.setPhone("010-1231-3123");
        memberDTO.setAge("19990101");

        // dto -> entity, 암호화 적용
        return Member.createMember(memberDTO, passwordEncoder);
    }


    @Test
    @DisplayName("회원가입 테스트")
    public void Testmember(){
        MemberDTO memberDTO = new MemberDTO();

        Member member = Member.builder()
                .memberId("aaa")
                .password("1234")
                .name("아파치")
                .email("aaa@naver.com")
                .age("24")
                .gender("남")
                .weight("70")
                .phone("010-7122-1234")
                .regDate(LocalDateTime.now())
                .role(Role.USER)
                .build();
        log.info("회원가입 데이터 "+member);
        Member.createMember(memberDTO,passwordEncoder);

        Member membertest = memberRepository.save(member);

        log.info("db 저장 데이터 "+membertest);

    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest(){

        Member member = createMember();
        Member savedMember =  loginService.saveUsers(member);

        // assertEquals메소드를 이용하여 저장하려고 요청했던 값과 실제 저장된 데이를 비교
        // assertEquals(기대값, 실제값);
        assertEquals(member.getEmail(), savedMember.getEmail());
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getMemberId(), savedMember.getMemberId());
        assertEquals(member.getPassword(), savedMember.getPassword());
        assertEquals(member.getRole(), savedMember.getRole());

    }

    @Test@DisplayName("중복 회원 테스트-이메일 기준")
    public void saveDuplicateMemberTest(){
        Member memberTest1 = createMember();
        Member memberTest2 = createMember();

        loginService.saveUsers(memberTest1);

        Throwable e = assertThrows(IllegalStateException.class, () ->{
            loginService.saveUsers(memberTest2);
        });

        assertEquals("이미 가입된 회원입니다.",e.getMessage());
    }


    @Test
    @DisplayName("로그인 성공 테스트")
    public void loginSuccessTest() throws Exception{
        String email = "aaa@naver.com";
        String password ="1234";

        mockMvc.perform(formLogin().userParameter("email")
                .loginProcessingUrl("/member/login")
                .user(email)
                .password(password)
        ).andExpect(SecurityMockMvcResultMatchers.authenticated());

    }

    @Test
    @DisplayName("로그인 실패 테스트")
    public void loginFailTest() throws Exception{
        String email = "aaa@naver.com";
        String password = "1234";

//        this.createMember(email,password);

        mockMvc.perform(
                formLogin().userParameter("email")
                        .loginProcessingUrl("/member/login")
                        .user(email)
                        .password(password)
        ).andExpect(SecurityMockMvcResultMatchers.unauthenticated());


    }



    @Test
    @DisplayName("회원 정보 등록 테스트 ")
    public void userinsertTest(){

        Member member = Member.builder()
                .memberId("aaa")
                .password("1234")
                .name("알파")
                .email("aaa@naver.com")
                .phone("010-1234-2344")
                .age("19990101")
                .build();

        Member result = memberRepository.save(member);

        log.info(result);
    }

}
