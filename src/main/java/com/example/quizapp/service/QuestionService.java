package com.example.quizapp.service;

import com.example.quizapp.model.Question;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    List<Question> getAllQuestions();

    void addQuestion(Question question);

    void updateQuestion(Long id, Question updatedQuestion);

    List<Question> getQuestionsBySubjectId(Long subjectId);
}
