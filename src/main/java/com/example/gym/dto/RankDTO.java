package com.example.gym.dto;

import lombok.*;

import javax.persistence.Column;
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RankDTO {


    private Long rankNo;  // 직급 번호
    private int salary;   // 월급
    private int lectureFee; // 강의비용

}
