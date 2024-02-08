package com.rocketseat.certificate.useCases;

import com.rocketseat.certificate.domain.certification.CertificationStudent;
import com.rocketseat.certificate.repositories.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Top10RankUseCase {
    @Autowired
    private CertificationRepository certificationRepository;

    public List<CertificationStudent> execute() {
        return this.certificationRepository.findTop10ByOrderByGradeDesc();
    }
}
