package com.example.gym.repository;

import com.example.gym.entity.MembershipPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipPaymentRepository extends JpaRepository<MembershipPayment,Long> {
}
