package com.microservicesAppSchool.school.repository;

import com.microservicesAppSchool.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
