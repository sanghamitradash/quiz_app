package com.example.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultylevel;
    private String category;

    public String getdifficultylevel() {
        return difficultylevel;
    }

    public void setdifficultylevel(String difficultyLevel) {
        this.difficultylevel = difficultyLevel;
    }
}