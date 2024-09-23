package com.example.quizapp.ServiceImpl;

import com.example.quizapp.model.Question;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void updateQuestion(Long id, Question updateQuestion) {
        Question existingQuestion = questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));

        existingQuestion.setQuestionTitle(updateQuestion.getQuestionTitle());
        existingQuestion.setOptions(updateQuestion.getOptions());
        existingQuestion.setRightAnswer(updateQuestion.getRightAnswer());

        questionRepository.save(existingQuestion);
    }

    @Override
    public List<Question> getQuestionsBySubjectId(Long subjectId) {
        return questionRepository.findBySubjectId(subjectId);
    }
}
