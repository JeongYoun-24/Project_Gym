package com.example.gym.dto;

import com.example.gym.constant.Role;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private String memberId;    // 아이디
    private String password;    // 비밀번호
    private String name;        // 이름
    private String email;       // 이메일
    private String phone;       // 전화번호
    private String gender;      // 성별
    private String age;         // 나이
    private String weight;      // 몸무게
    private String memberShipCheck;  // 회원권 여부 (on off)
    private LocalDateTime regDate;  // 회원가입 날짜


}

