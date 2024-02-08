package com.rocketseat.certificate.domain.student;

import com.rocketseat.certificate.domain.questions.QuestionAnswerDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentCertificationAnswerDTO {

    private String email;
    private String technology;
    private List<QuestionAnswerDTO> questionsAnswers;
}
