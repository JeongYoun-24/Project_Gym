package com.example.gym.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name="ShipHistory")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShipHistory {

    @Id
    @Column(name="ship_no")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long shipNo;   // 결제내역 번호

    private int months;         // 개월수
    private int price;          // 금액
    private LocalDateTime shipDate; // 결제 일자

    @ManyToOne
    @JoinColumn(name = "membership_no")
    private Membership membership; // 회원권 번호
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;  // 회원 아이디





}
