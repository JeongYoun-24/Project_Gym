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
