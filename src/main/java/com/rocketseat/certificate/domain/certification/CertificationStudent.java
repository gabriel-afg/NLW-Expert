package com.rocketseat.certificate.domain.certification;

import com.rocketseat.certificate.domain.answerCertification.AnswerCertification;
import com.rocketseat.certificate.domain.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "certifications")
@Table(name = "certifications")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class CertificationStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @JoinColumn(name = "student_id")
    private UUID studentID;
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;
    private String technology;
    private Integer grate;

    @OneToMany
    @JoinColumn(name = "answer_certification_id", insertable = false, updatable = false)
    private List<AnswerCertification> answerCertifications;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
