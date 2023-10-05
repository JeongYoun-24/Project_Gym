package com.example.gym.service.rank;

import com.example.gym.dto.MembershipDTO;
import com.example.gym.dto.RankDTO;

public interface RankService {


    public String register(RankDTO rankDTO); // 회원권 등록
    public RankDTO readOne(Long rankNo);   // 회원권 조회
    public void modify(RankDTO rankDTO);    // 회원권 수정
    public void remove(Long rankNo);      // 회원권 삭제




}
