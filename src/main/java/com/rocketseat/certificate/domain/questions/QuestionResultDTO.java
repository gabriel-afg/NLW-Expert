package com.rocketseat.certificate.domain.questions;

import com.rocketseat.certificate.domain.alternatives.AlternativeResultDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


public record QuestionResultDTO(
         UUID id,
         String technology,
         String description,

         List<AlternativeResultDTO> alternatives
) {
    public QuestionResultDTO(Question question){
        this(
                question.getId(),
                question.getTechnology(),
                question.getDescription(),
                question.getAlternatives().stream().map(AlternativeResultDTO::new).toList()
        );
    }

}