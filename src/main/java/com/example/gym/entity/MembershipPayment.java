package com.example.gym.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@Table(name="membership_payment")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MembershipPayment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="payment_no")
    private Long paymentNo;          /// 결제 아이디

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;         // 프로그램 아이디
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;          // 회원 아이디
    @ManyToOne
    @JoinColumn(name = "membership_no")
    private Membership membership;   // 회원권 번호


    private LocalDateTime PaymentDate;    // 결제 일자
    private int paymentPrice;             // 결제 금액
    private String paymentMethod;         // 결제 수단



}
