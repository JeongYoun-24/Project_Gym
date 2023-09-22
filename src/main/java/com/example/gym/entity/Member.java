package com.example.gym.entity;

import com.example.gym.constant.Role;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private String memberShipCheck;  // 회원권 여부 (on off)

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime regDate;  // 회원가입 날짜


  /*  public static Member createMember(MemberDTO memberDTO, PasswordEncoder passwordEncoder){
        Member member = new Member();

        member.setName(usersDTO.getName());
        member.setEmail(usersDTO.getEmail());
        member.setUserid(usersDTO.getUserid());
        member.setPhone(usersDTO.getPhone());
        member.setBirthDate(usersDTO.getBirthDate());

        // 암호화
        String password = passwordEncoder.encode(usersDTO.getPassword());
        member.setPassword(password);
        member.setRole(Role.USER);
//        users.setRole(Role.ADMIN);
//        users.setRole(Role.MANAGER);

        return member;
    }*/


}
