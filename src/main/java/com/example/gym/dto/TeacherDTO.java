package com.example.gym.dto;

import com.example.gym.entity.Rank;

import javax.persistence.*;

public class TeacherDTO {


    private String employeeId;   // 직원 아이디

    private Long rankNo;        // 직급 아이디
    private String name;         // 직원 이름
    private String phone;        // 직원 전화번호
    private String email;        // 직원 이메일
    private String line;         // 직원 계열 (요가강사,헬스트레이너,매니저,청소부)


}
