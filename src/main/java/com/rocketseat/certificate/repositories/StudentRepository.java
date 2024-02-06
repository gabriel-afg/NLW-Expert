package com.rocketseat.certificate.repositories;

import com.rocketseat.certificate.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
