package com.example.gym.dto;

import com.example.gym.entity.Member;
import com.example.gym.entity.Membership;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ShipHistoryDTO {


    private Long shipNo;   // 결제내역 번호

    private int months;         // 개월수
    private int price;          // 금액
    private LocalDateTime shipDate; // 결제 일자

    private Long membershipNo; // 회원권 번호

    private String memberId;  // 회원 아이디





}
