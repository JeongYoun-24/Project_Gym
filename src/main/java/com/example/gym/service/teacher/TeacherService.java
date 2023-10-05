package com.example.gym.service.teacher;

import com.example.gym.dto.MembershipDTO;
import com.example.gym.dto.TeacherDTO;

public interface TeacherService {


    public String register(TeacherDTO teacherDTO); // 회원권 등록
    public TeacherDTO readOne(String employeeId);   // 회원권 조회
    public void modify(TeacherDTO teacherDTO);    // 회원권 수정
    public void remove(String employeeId);      // 회원권 삭제




}
