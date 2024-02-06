package com.rocketseat.certificate.domain.student;

import com.rocketseat.certificate.domain.certification.CertificationStudent;
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
public class Student {

    private UUID id;
    private String email;
    private List<CertificationStudent> certificationStudents;
}
