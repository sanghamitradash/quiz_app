package com.example.quizapp.service;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.Subject;

import java.util.List;
import java.util.Map;

public interface StudentService {
    public List<Subject> getAllSubjects();

    List<Question> getQuestionsBySubjectId(Long subjectId);

    void processAnswers(Map<String, String> answers, String studentUserName);
}
