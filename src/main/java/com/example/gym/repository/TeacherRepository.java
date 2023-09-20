package com.example.gym.repository;

import com.example.gym.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository  extends JpaRepository<Teacher,String> {
}
