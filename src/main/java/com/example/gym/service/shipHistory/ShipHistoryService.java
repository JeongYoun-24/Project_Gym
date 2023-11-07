package com.example.gym.service.shipHistory;

import com.example.gym.dto.RankDTO;
import com.example.gym.dto.ShipHistoryDTO;

public interface ShipHistoryService  {

    public Long register(ShipHistoryDTO shipHistoryDTO); // 회원권 등록
    public ShipHistoryDTO readOne(Long shipNo);   // 회원권 조회
    public void modify(ShipHistoryDTO shipHistoryDTO);    // 회원권 수정
    public void remove(Long shipNo);      // 회원권 삭제


}
