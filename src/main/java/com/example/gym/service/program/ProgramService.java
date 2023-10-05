package com.example.gym.service.program;

import com.example.gym.dto.MembershipDTO;
import com.example.gym.dto.ProgramDTO;

public interface ProgramService {


    public String register(ProgramDTO programDTO); // 회원권 등록
    public ProgramDTO readOne(String programId);   // 회원권 조회
    public void modify(ProgramDTO programDTO);    // 회원권 수정
    public void remove(String programId);      // 회원권 삭제




}
