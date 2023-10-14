package com.example.gym.service.teacher;

import com.example.gym.dto.MembershipDTO;
import com.example.gym.dto.RankDTO;
import com.example.gym.dto.TeacherDTO;
import com.example.gym.entity.Rank;
import com.example.gym.entity.Teacher;
import com.example.gym.repository.PaymentHistoryRepository;
import com.example.gym.repository.RankRepository;
import com.example.gym.repository.TeacherRepository;
import com.example.gym.service.rank.RankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class TeacherServicelmpl implements TeacherService {

    private final ModelMapper modelMapper;
    private final TeacherRepository teacherRepository;
    private final RankRepository rankRepository;
    @Override
    public String register(TeacherDTO teacherDTO) {

        Rank rank  =  rankRepository.findById(teacherDTO.getRankNo()).orElseThrow(EntityExistsException::new);



        Teacher teacher = modelMapper.map(teacherDTO,Teacher.class);// DTO 값 Entity값으로 변환

         teacher.setRank(rank); //폴딩키 값 삽입

        Teacher teacher1 = teacherRepository.save(teacher); // JPA로 DB 저장하고 저장한 값 불러오기


        return teacher1.getEmployeeId(); // 저장한 아이디값 전달
    }

    @Override
    public TeacherDTO readOne(String employeeId) {
        return null;
    }

    @Override
    public void modify(TeacherDTO teacherDTO) {

    }

    @Override
    public void remove(String employeeId) {

    }
}
