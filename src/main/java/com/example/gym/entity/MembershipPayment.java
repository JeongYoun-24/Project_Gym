package com.example.gym.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

public class MembershipPayment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="program_No")
    private Long programNo;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "membership_no")
    private Membership membership;


    private LocalDateTime PaymentDate;
    private int paymentPrice;
    private String paymentMethod;



}
