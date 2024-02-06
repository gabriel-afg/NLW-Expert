package com.rocketseat.certificate.domain.certification;

import com.rocketseat.certificate.domain.answerCertification.AnswerCertification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class CertificationStudent {

    private UUID id;
    private UUID studentId;
    private String technology;
    private Integer grate;
    private List<AnswerCertification> answerCertifications;
}
