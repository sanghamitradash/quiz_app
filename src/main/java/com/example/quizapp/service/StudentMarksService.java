package com.example.quizapp.service;

import com.example.quizapp.model.StudentMarks;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentMarksService {

    List<StudentMarks> getAllStudentMarks();
}
