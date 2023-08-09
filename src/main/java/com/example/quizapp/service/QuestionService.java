package com.example.quizapp.service;

import com.example.quizapp.model.Question;
import com.example.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    private boolean questionTitle;
    private boolean option1;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("errorMessage", HttpStatus.INTERNAL_SERVER_ERROR);
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
            questionDao.deleteById(id) ;
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}


