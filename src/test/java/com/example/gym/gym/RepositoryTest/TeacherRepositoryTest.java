package com.example.gym.gym.RepositoryTest;

import com.example.gym.GymApplication;
import com.example.gym.entity.Teacher;
import com.example.gym.repository.TeacherRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Log4j2
@AutoConfigureMockMvc
@SpringBootTest(classes = GymApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    public void TeacherTest(){
        Teacher teacher = Teacher.builder()


                .build();



    }



}
