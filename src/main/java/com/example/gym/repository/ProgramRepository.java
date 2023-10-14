package com.example.gym.repository;

import com.example.gym.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program,String> {
}
