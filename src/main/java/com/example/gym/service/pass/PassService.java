package com.example.gym.service.pass;

import com.example.gym.dto.MembershipDTO;
import com.example.gym.dto.PassDTO;

public interface PassService {


    public String register(PassDTO passDTO); // 회원권 등록
    public PassDTO readOne(Long passNo);   // 회원권 조회
    public void modify(PassDTO passDTO);    // 회원권 수정
    public void remove(Long passNo);      // 회원권 삭제




}
