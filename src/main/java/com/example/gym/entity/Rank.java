package com.example.gym.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Table(name="ranks")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rank {  // 직급

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "rank_no")
    private Long rankNo;  // 직급 번호

    private int salary;   // 월급
    private int LectureFee; // 강의비용


}
