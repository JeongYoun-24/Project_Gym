package com.example.gym.gym.RepositoryTest;

import com.example.gym.GymApplication;
import com.example.gym.entity.Rank;
import com.example.gym.repository.RankRepository;
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
public class RankRepositoryTest {


    @Autowired
    private RankRepository rankRepository;


    @Test
    @DisplayName("직급 데이터 저장 테스트")
    public void RankTest(){
        Rank rank = Rank.builder()
//                .rankNo(1L)      // 오토 시퀀스 적용
                .salary(3000000)  //  월급
                .lectureFee(300000) // 강의비용
                .build();

        log.info("직급 데이터 "+rank);
      rank  =  rankRepository.save(rank);
        log.info("db에 저장된 데이터"+rank);

    }






}
