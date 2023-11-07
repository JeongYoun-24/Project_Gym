package com.example.gym.repository;

import com.example.gym.entity.Member;
import com.example.gym.entity.ShipHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipHistoryRepository extends JpaRepository<ShipHistory,Long> {

    ShipHistory findByMembership_MembershipNo(Long membershipNo); // 회원권 찾기


}
