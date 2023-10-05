package com.example.gym.service.membership;

import com.example.gym.dto.MembershipDTO;

public interface MembershipService {


    public Long register(MembershipDTO membershipDTO); // 회원권 등록
    public MembershipDTO readOne(Long membershipNo);   // 회원권 조회
    public void modify(MembershipDTO membershipDTO);    // 회원권 수정
    public void remove(Long membershipNo);      // 회원권 삭제




}
