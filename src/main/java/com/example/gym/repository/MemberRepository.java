package com.example.gym.repository;

import com.example.gym.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> { // 회원 레포지스토리

    Member findByUserid(String userid);

    Member findByNameOrEmail(String name,String email); // 아이디 찾기
    Member findByMemberIdOrEmail(String memberId,String email); // 비밀번호 찾기

    Member findByEmail(String email);
    Member findByName(String name);
}
