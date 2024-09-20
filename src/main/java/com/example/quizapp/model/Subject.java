package com.example.quizapp.model;

import com.example.quizapp.repository.SubjectRepository;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "subject")
public class Subject{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subjectName;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.EAGER)
    private Set<Student> students;
}
