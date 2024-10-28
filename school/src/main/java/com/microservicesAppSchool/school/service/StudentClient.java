package com.microservicesAppSchool.school.service;

import com.microservicePractice.student.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${spring.application.config.student-url}")
public interface StudentClient {

    @GetMapping("/school/{school-id}")
    List<Student> findAllStudentBySchool(@PathVariable("school-id") Integer schoolId);
}
