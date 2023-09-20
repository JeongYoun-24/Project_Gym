package com.example.gym.repository;

import com.example.gym.entity.Pass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassRepository extends JpaRepository<Pass,Long> { // 출입부 레포지스토리



}
