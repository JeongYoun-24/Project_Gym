package com.example.gym.repository;

import com.example.gym.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> { // 회원 레포지스토리


}
