package com.microservicesAppSchool.school.service;

import com.microservicePractice.student.entity.Student;
import com.microservicesAppSchool.school.entity.Dto.FullSchoolResponse;
import com.microservicesAppSchool.school.entity.School;
import com.microservicesAppSchool.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;

    public void saveSchool(School school) {
        repository.save(school);
    }

    public List<School> findAllSchools() {
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        School school = repository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        List<Student> students = client.findAllStudentBySchool(schoolId);
        
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
