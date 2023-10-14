package com.example.gym.dto;

import com.example.gym.entity.Rank;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {


    private String employeeId;   // 직원 아이디

    private Long rankNo;        // 직급 아이디
    // @NotBlank(message = "직원 이름 필수 입력값입니다.")
    private String name;         // 직원 이름
    // @NotBlank(message = "전화번호는 필수 입력입니다.")
    private String phone;        // 직원 전화번호
    // @NotBlank(message = "이메일은 필수 입력값입니다.")
    private String email;        // 직원 이메일
    // @NotBlank(message = "계열 필수 입력값입니다.")
    private String line;         // 직원 계열 (요가강사,헬스트레이너,매니저,청소부)


}
