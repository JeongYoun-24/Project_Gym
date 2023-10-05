package com.example.gym.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name="membership")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Membership {  // 회원권

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="membership_no")
    private Long membershipNo;  // 회원권 번호
    private int months;         // 개월수
    private int price;          // 금액


    public void change(int months, int price){
        this.months = months;
        this.price = price;
    }

}
