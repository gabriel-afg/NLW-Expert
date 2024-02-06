package com.rocketseat.certificate.useCases;

import com.rocketseat.certificate.domain.student.StudentRequestDTO;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class VerifyHasCertificationUseCase {

    public boolean execute(StudentRequestDTO data){
        return Objects.equals(data.email(), "gabriel.afg182@gmail.com") && Objects.equals(data.technology(), "JAVA");
    }
}
