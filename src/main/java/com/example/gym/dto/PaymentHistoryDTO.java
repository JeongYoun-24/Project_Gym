package com.example.gym.dto;

import com.example.gym.entity.MembershipPayment;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentHistoryDTO {


    private Long historyId;                        // 내역 아이디
    private Long payment_no;  // 결제 아이디
    private int paymentPrice;                      // 결제 금액
    private LocalDateTime paymentDate;              // 결제 일자
    private String paymentMethod;                // 결제 수단

}
