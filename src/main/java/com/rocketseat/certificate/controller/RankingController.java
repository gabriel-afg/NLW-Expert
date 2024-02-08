package com.rocketseat.certificate.controller;

import com.rocketseat.certificate.domain.certification.CertificationStudent;
import com.rocketseat.certificate.useCases.Top10RankUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {
    @Autowired
    private Top10RankUseCase top10RankUseCase;

    @GetMapping("/top10")
    public List<CertificationStudent> top10(){
        return this.top10RankUseCase.execute();
    }
}
