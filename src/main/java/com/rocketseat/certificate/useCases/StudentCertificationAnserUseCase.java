package com.rocketseat.certificate.useCases;

import com.rocketseat.certificate.domain.alternatives.Alternatives;
import com.rocketseat.certificate.domain.answerCertification.AnswerCertification;
import com.rocketseat.certificate.domain.certification.CertificationStudent;
import com.rocketseat.certificate.domain.questions.Question;
import com.rocketseat.certificate.domain.student.Student;
import com.rocketseat.certificate.domain.student.StudentCertificationAnswerDTO;
import com.rocketseat.certificate.domain.student.StudentRequestDTO;
import com.rocketseat.certificate.repositories.CertificationRepository;
import com.rocketseat.certificate.repositories.QuestionRepository;
import com.rocketseat.certificate.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentCertificationAnserUseCase {

    @Autowired
    private CertificationRepository certificationRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private VerifyHasCertificationUseCase verifyHasCertificationUseCase;

    public CertificationStudent execute(StudentCertificationAnswerDTO dto) throws Exception {
        var hasCertification = this.verifyHasCertificationUseCase
                .execute(new StudentRequestDTO(dto.getEmail(), dto.getTechnology()));

        if (hasCertification) {
            throw new Exception("Você já tirou sua certificação!");
        }

        List<Question> questions = questionRepository.findByTechnology(dto.getTechnology());
        List<AnswerCertification> answersCertifications = new ArrayList<>();

        AtomicInteger correctAnswers = new AtomicInteger(0);

        dto.getQuestionsAnswers().forEach(questionAnswer -> {
            var question = questions.stream()
                    .filter(q -> q.getId().equals(questionAnswer.getQuestionID())).findFirst().get();

            var findCorrectAlternative = question.getAlternatives().stream().filter(Alternatives::isCorrect).findFirst().get();

            if (findCorrectAlternative.getId().equals(questionAnswer.getAlternativeID())){
                questionAnswer.setCorrect(true);
                correctAnswers.incrementAndGet();
            }
            else {
                questionAnswer.setCorrect(false);
            }

            var answersCertificationsEntity = AnswerCertification.builder()
                    .answerId(questionAnswer.getAlternativeID())
                    .questionId(questionAnswer.getQuestionID())
                    .isCorrect(questionAnswer.isCorrect()).build();

            answersCertifications.add(answersCertificationsEntity);
        });


        var student = studentRepository.findByEmail(dto.getEmail());
        UUID studentID;
        if (student.isEmpty()) {
            var studentCreated = Student.builder().email(dto.getEmail()).build();
            studentCreated = studentRepository.save(studentCreated);
            studentID = studentCreated.getId();
        } else {
            studentID = student.get().getId();
        }

        CertificationStudent certificationStudentEntity = CertificationStudent.builder()
                .technology(dto.getTechnology())
                .studentID(studentID)
                .grate(correctAnswers.get())
                .build();

        var certificationStudentCreated = certificationRepository.save(certificationStudentEntity);

        answersCertifications.forEach(answerCertification -> {
            answerCertification.setCertificationId(certificationStudentEntity.getId());
            answerCertification.setCertificationStudent(certificationStudentEntity);
        });

        certificationStudentEntity.setAnswerCertifications(answersCertifications);

        certificationRepository.save(certificationStudentEntity);

        return certificationStudentCreated;
    }

}
