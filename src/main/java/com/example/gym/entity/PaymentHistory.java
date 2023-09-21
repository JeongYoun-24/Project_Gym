package com.example.gym.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name="payment_history")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="program_No")
    private Long historyId;                        // 내역 아이디

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_no")
    private MembershipPayment membershipPayment;  // 결제 아이디

    private int paymentPrice;                      // 결제 금액
    private LocalDateTime paymentDate;              // 결제 일자
    private String paymentMethod;                   // 결제 수단


}
