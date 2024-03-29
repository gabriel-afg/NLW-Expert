package com.rocketseat.certificate.controller;

import com.rocketseat.certificate.domain.alternatives.AlternativeResultDTO;
import com.rocketseat.certificate.domain.alternatives.Alternatives;
import com.rocketseat.certificate.domain.questions.Question;
import com.rocketseat.certificate.domain.questions.QuestionResultDTO;
import com.rocketseat.certificate.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology){
        var result = this.questionRepository.findByTechnology(technology);

        return result.stream().map(QuestionResultDTO::new).toList();
    }
}
