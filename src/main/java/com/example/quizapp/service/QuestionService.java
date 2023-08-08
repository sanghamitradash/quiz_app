package com.example.quizapp.service;

import com.example.quizapp.model.Question;
import com.example.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    private boolean questionTitle;
    private boolean option1;

    public List<Question> getAllQuestions() {

//
        return questionDao.findAll();
    }

    public Optional<Question> getQuestionsById(Integer id) {
        return questionDao.findById(id);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Success";
    }

    public String updateQuestion(Integer id, Question updatedQuestion) {
        Optional<Question> existingQuestionOptional = questionDao.findById(id);

        if (existingQuestionOptional.isPresent()) {
            Question existingQuestion = existingQuestionOptional.get();

            // Update the properties of existingQuestion with the properties of updatedQuestion
            existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
            existingQuestion.setOption1(updatedQuestion.getOption1());
            existingQuestion.setOption2(updatedQuestion.getOption2());
            existingQuestion.setOption3(updatedQuestion.getOption3());
            existingQuestion.setOption4(updatedQuestion.getOption4());
            existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());

            // Update difficulty level if the setter method is available in Question class
            existingQuestion.setdifficultylevel(updatedQuestion.getdifficultylevel());

            existingQuestion.setCategory(updatedQuestion.getCategory());

            // Save the updated question
            questionDao.save(existingQuestion);

            return "success";
        } else {
            return "not_found";
        }
    }

    public boolean deleteQuestion(Integer id){
        try{
            questionDao.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}


