package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String>  addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);

    }

    @PutMapping("update/{id}")
    public String updateQuestion(@PathVariable Integer id, @RequestBody Question updatedQuestion) {
        String result = String.valueOf(questionService.updateQuestion(id, updatedQuestion));
        if (result.equals("success")) {
            return "Question updated successfully.";
        } else {
            return "Failed to update question.";
        }
    }

//    @DeleteMapping("delete/{id}")
//    public String deleteQuestion(@PathVariable Integer id){
//        if(questionService.deleteQuestion(id)){
//            return "Question deleted successfully";
//        }
//        else{
//            return "Failed to delete question";
//        }
//    }

}