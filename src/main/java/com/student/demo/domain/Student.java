package com.student.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="Student_Management")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;
//    @NotBlank
    @Column(name = "student_number", nullable = false)
    private String studentNumber; //"        "
//    @NotBlank
    private String firstName;
    @Column(nullable = true)
    private String middleName;
//    @NotBlank
    private String lastName;
    private Double cgpa;
//    @NotBlank
    private LocalDate enrollmentDate;
//    @NotBlank
    private Boolean isInternational;
}
