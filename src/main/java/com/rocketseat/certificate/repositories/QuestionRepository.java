package com.rocketseat.certificate.repositories;

import com.rocketseat.certificate.domain.questions.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
    List<Question> findByTechnology(String technology);
}
