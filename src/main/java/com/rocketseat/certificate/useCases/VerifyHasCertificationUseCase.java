package com.rocketseat.certificate.useCases;

import com.rocketseat.certificate.domain.student.StudentRequestDTO;
import com.rocketseat.certificate.repositories.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class VerifyHasCertificationUseCase {

    @Autowired
    private CertificationRepository certificationRepository;

    public boolean execute(StudentRequestDTO dto) {
        var result = this.certificationRepository.findByStudentEmailAndTechnology(dto.email(),
                dto.technology());
        return !result.isEmpty();
    }
}
