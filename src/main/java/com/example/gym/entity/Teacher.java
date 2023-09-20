package com.example.gym.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name="teacher")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher { // 트레이너및 강사 등록 아이디

    @Id
    @Column(name="employee_id")
    private String employeeId;   // 직원 아이디
    private String name;         // 직원 이름
    private String phone;        // 직원 전화번호
    private String email;        // 직원 이메일
    private String line;         // 직원 계열 (요가강사,헬스트레이너,매니저,청소부)

}
