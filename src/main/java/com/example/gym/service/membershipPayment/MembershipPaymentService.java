package com.example.gym.service.membershipPayment;

import com.example.gym.dto.MembershipPaymentDTO;
import com.example.gym.dto.PassDTO;

public interface MembershipPaymentService {


    public Long register(MembershipPaymentDTO membershipPaymentDTO); // 회원권 등록
    public MembershipPaymentDTO readOne(Long paymentNo);   // 회원권 조회
    public void modify(MembershipPaymentDTO membershipPaymentDTO);    // 회원권 수정
    public void remove(Long paymentNo);      // 회원권 삭제
}
