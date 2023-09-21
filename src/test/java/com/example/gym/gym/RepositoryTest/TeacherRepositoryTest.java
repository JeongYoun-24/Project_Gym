package com.example.gym.gym.RepositoryTest;

import com.example.gym.GymApplication;
import com.example.gym.entity.Rank;
import com.example.gym.entity.Teacher;
import com.example.gym.repository.RankRepository;
import com.example.gym.repository.TeacherRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;

@Log4j2
@AutoConfigureMockMvc
@SpringBootTest(classes = GymApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private RankRepository rankRepository;


    public Rank RankJoin(){
        Rank rank = Rank.builder()
//                .rankNo(1L)      // 오토 시퀀스 적용
                .salary(3000000)  //  월급
                .lectureFee(300000) // 강의비용
                .build();
        rank  =  rankRepository.save(rank);



        // dto -> entity, 암호화 적용
        return rank;
    }

    @Test
    @DisplayName("직원 정보 등록 테스트 ")
    public void TeacherTest(){
        Rank rank = RankJoin();
        log.info("직급"+rank);

        Teacher teacher = Teacher.builder()
                .employeeId("abcd1234")
                .rank(rank)
                .name("김종국")
                .phone("010-1234-1234")
                .email("kim@naver.com")
                .line("헬스트레이너")
                .build();
    log.info("직원 데이터 "+teacher);

    teacher= teacherRepository.save(teacher);

    log.info("db저장 데이터"+teacher);

    }



}
