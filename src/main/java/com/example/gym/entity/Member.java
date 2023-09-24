package com.example.gym.entity;

import com.example.gym.constant.Role;
import com.example.gym.dto.MemberDTO;
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
    private String phone;       // 전화번호
    private String gender;      // 성별
    private String age;         // 나이
    private String weight;      // 몸무게
    private String memberShipCheck;  // 회원권 여부 (on off)

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime regDate;  // 회원가입 날짜


    // update(변경) aptjem 정의
    public void change(String password,String name,String email){
        this.password = password;
        this.name = name;
        this.email = email;

    }
    // 비밀번호 변경 메서드
    public void pwdUpdate(String password, PasswordEncoder passwordEncoder){
        Member member = new Member();

        this.password = password;
        String password2 = passwordEncoder.encode(password);
        member.setPassword(password2);

    }


    // 회원가입시 비밀번호 암호화
    public static Member createMember(MemberDTO memberDTO, PasswordEncoder passwordEncoder){
        Member users = new Member();

        users.setName(memberDTO.getName());
        users.setEmail(memberDTO.getEmail());
        users.setMemberId(memberDTO.getMemberId());
        users.setPhone(memberDTO.getPhone());
        users.setGender(memberDTO.getGender());

        // 암호화
        String password = passwordEncoder.encode(memberDTO.getPassword());
        users.setPassword(password);
        users.setRole(Role.USER);
//        users.setRole(Role.ADMIN);
//        users.setRole(Role.MANAGER);

        return users;
    }

}
