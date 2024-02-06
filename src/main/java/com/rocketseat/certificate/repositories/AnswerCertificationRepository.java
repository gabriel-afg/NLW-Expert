package com.rocketseat.certificate.repositories;

import com.rocketseat.certificate.domain.answerCertification.AnswerCertification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnswerCertificationRepository extends JpaRepository<AnswerCertification, UUID> {
}
