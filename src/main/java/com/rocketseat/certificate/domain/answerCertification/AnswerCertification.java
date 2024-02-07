package com.rocketseat.certificate.domain.answerCertification;

import com.rocketseat.certificate.domain.certification.CertificationStudent;
import com.rocketseat.certificate.domain.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "answerCertification")
@Table(name = "answerCertification")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class AnswerCertification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "certification_id")
    private UUID certificationId;

    @ManyToOne
    @JoinColumn(name = "certification_id", insertable = false, updatable = false)
    private CertificationStudent certificationStudent;

    @Column(name = "student_id")
    private UUID studentId;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @Column(name = "question_id")
    private UUID questionId;

    @Column(name = "answer_id")
    private UUID answerId;

    private boolean isCorrect;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
