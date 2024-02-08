package com.rocketseat.certificate.controller;

import com.rocketseat.certificate.domain.student.Student;
import com.rocketseat.certificate.domain.student.StudentCertificationAnswerDTO;
import com.rocketseat.certificate.domain.student.StudentRequestDTO;
import com.rocketseat.certificate.useCases.StudentCertificationAnserUseCase;
import com.rocketseat.certificate.useCases.VerifyHasCertificationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyHasCertificationUseCase verifyHasCertificationUseCase;

    @Autowired
    private StudentCertificationAnserUseCase studentCertificationAnserUseCase;

    @PostMapping("/verifyCertification")
    public String verifyCertification(@RequestBody StudentRequestDTO data){

        var result = this.verifyHasCertificationUseCase.execute(data);
        if(result) {
            return "Usuario ja fez a prova";
        }

        return "Usuario pode fazer a prova";
    }

    @PostMapping("/certification/answer")
    public ResponseEntity<Object> certificationAnswer(
            @RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
        try {
            var result = studentCertificationAnserUseCase.execute(studentCertificationAnswerDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
