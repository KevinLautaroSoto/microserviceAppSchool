package com.microservicePractice.student.repository;

import com.microservicePractice.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAlllBySchoolId(Integer schoolId);
}
