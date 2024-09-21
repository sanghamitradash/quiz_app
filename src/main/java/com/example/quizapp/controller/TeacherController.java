package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.StudentMarks;
import com.example.quizapp.model.Subject;
import com.example.quizapp.service.QuestionService;
import com.example.quizapp.service.StudentMarksService;
import com.example.quizapp.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseErrorHandler;

import java.util.List;

@Controller
@RequestMapping("/teacher")
@PreAuthorize("hasRole('TEACHER')")
public class TeacherController {

    @Autowired
    SubjectService subjectService;

    @Autowired
    QuestionService questionService;

    @Autowired
    StudentMarksService StudentMarksService;

    @GetMapping("/manageSubjects")
    public String getAllSubjects(Model model){
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "manageSubjects";
    }

    @PostMapping("/addSubjects")
    public ResponseEntity<String> addSubject(@RequestBody Subject subject){
        subjectService.addSubject(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body("Subject added successfully");
    }

    @PutMapping("/updateSubject/{id}")
    public ResponseEntity<String> updateSubject(@PathVariable Long id, @RequestBody Subject updatedSubject){
        subjectService.updateSubject(id, updatedSubject);
        return ResponseEntity.ok("Subject updated successfully");
    }

    @GetMapping("/manageQuestions")
    public String getAllQuestions(Model model){
        List<Question> questions = questionService.getAllQuestions();
        model.addAttribute("questions");
        return "manageQuestions";
    }

    @PostMapping("/addQuestions")
    public ResponseEntity<String>  addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body("Question added successfully");
    }

    @PutMapping("/updateQuestions/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable Long id, @RequestBody Question updateQuestion) {
        questionService.updateQuestion(id, updateQuestion);
        return ResponseEntity.ok("Question updated successfully");
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

    @GetMapping("/student/marks")
    public ResponseEntity<List<StudentMarks>> studentMarks(Model model){
        List<StudentMarks> studentMarksList = StudentMarksService.getAllStudentMarks();
        model.addAttribute("studentMarks", studentMarksList);
        return ResponseEntity.ok(studentMarksList);
    }

}