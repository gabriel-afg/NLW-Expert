package com.rocketseat.certificate.repositories;

import com.rocketseat.certificate.domain.certification.CertificationStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CertificationRepository extends JpaRepository<CertificationStudent, UUID> {
    @Query("SELECT c FROM certifications c INNER JOIN c.student std WHERE std.email = :email AND c.technology = :technology")
    List<CertificationStudent> findByStudentEmailAndTechnology(String email, String technology);
}
