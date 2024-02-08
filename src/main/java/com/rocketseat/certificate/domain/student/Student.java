package com.rocketseat.certificate.domain.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rocketseat.certificate.domain.certification.CertificationStudent;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "students")
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String email;
    @OneToMany(mappedBy = "student")
    @JsonBackReference
    private List<CertificationStudent> certificationStudents;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
