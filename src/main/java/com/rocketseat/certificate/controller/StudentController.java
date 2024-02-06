package com.rocketseat.certificate.controller;

import com.rocketseat.certificate.domain.student.StudentRequestDTO;
import com.rocketseat.certificate.useCases.VerifyHasCertificationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyHasCertificationUseCase verifyHasCertificationUseCase;

    @PostMapping("/verifyCertification")
    public String verifyCertification(@RequestBody StudentRequestDTO data){

        var result = this.verifyHasCertificationUseCase.execute(data);
        if(result) {
            return "Usuario ja fez a prova";
        }

        return "Usuario pode fazer a prova";
    }
}
