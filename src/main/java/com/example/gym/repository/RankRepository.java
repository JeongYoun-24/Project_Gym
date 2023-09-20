package com.example.gym.repository;

import com.example.gym.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepository extends JpaRepository<Rank,Long> {
}
