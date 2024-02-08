package com.rocketseat.certificate.domain.certification;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rocketseat.certificate.domain.answerCertification.AnswerCertification;
import com.rocketseat.certificate.domain.student.Student;
import jakarta.persistence.*;
import lombok.*;
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
@Builder
public class CertificationStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(name = "student_id")
    private UUID studentID;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;
    private String technology;
    private Integer grate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_certification_id", insertable = false, updatable = false)
    @JsonManagedReference
    private List<AnswerCertification> answerCertifications;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
