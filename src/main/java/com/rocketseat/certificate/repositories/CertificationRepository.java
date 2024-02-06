package com.rocketseat.certificate.repositories;

import com.rocketseat.certificate.domain.certification.CertificationStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CertificationRepository extends JpaRepository<CertificationStudent, UUID> {
}
