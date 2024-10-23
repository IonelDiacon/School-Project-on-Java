package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Getter
@Setter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int grade;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne  // Schimbat de la ManyToOne la OneToOne
    @JoinColumn(name = "course_id", unique = true)  // Adăugăm unique pentru a asigura o relație OneToOne
    @JsonBackReference  // Partea de referință a relației
    private Course course;

    // Getters și Setters
}
