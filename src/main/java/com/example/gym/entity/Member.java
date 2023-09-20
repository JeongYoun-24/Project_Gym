package com.example.gym.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Table(name="member")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {    // 회원 정보

    @Id
    @Column(name="member_id")
    private String memberId;    // 아이디
    private String password;    // 비밀번호
    private String name;        // 이름
    private String email;       // 이메일
    private String gender;      // 성별
    private String age;         // 나이
    private String weight;      // 몸무게


}
