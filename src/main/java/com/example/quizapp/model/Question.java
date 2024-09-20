package com.example.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;

    private String questionTitle;
    private List<String> options;
    private String rightAnswer;
    private Integer marks;

}