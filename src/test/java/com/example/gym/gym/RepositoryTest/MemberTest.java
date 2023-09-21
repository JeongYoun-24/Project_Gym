package com.example.gym.gym.RepositoryTest;

import com.example.gym.GymApplication;
import com.example.gym.entity.Member;
import com.example.gym.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Log4j2
@AutoConfigureMockMvc
@SpringBootTest(classes = GymApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class MemberTest {


    @Autowired
    private MemberRepository memberRepository;


    @Test
    @DisplayName("회원가입 테스트")
    public void Testmember(){
        Member member = Member.builder()
                .memberId("aaa")
                .password("1234")
                .name("아파치")
                .email("aaa@naver.com")
                .age("24")
                .gender("남")
                .weight("70")
                .build();
        log.info("회원가입 데이터 "+member);
        Member membertest = memberRepository.save(member);

        log.info("db 저장 데이터 "+membertest);

    }



}
