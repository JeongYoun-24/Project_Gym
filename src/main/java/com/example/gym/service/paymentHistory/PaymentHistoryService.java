package com.example.gym.service.paymentHistory;

import com.example.gym.dto.MembershipDTO;
import com.example.gym.dto.PaymentHistoryDTO;

public interface PaymentHistoryService {


    public String register(PaymentHistoryDTO paymentHistoryDTO); // 회원권 등록
    public PaymentHistoryDTO readOne(Long historyId);   // 회원권 조회
    public void modify(PaymentHistoryDTO paymentHistoryDTO);    // 회원권 수정
    public void remove(Long historyId);      // 회원권 삭제




}
