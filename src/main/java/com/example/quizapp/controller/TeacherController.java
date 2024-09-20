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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseErrorHandler;

import java.util.List;

@RestController
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
    public ResponseEntity<List<Subject>> getAllSubjects(Model model){
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return ResponseEntity.ok(subjects);
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
    public ResponseEntity<List<Question>> getAllQuestions(Model model){
        List<Question> questions = questionService.getAllQuestions();
        model.addAttribute("manageQuestions");
        return ResponseEntity.ok(questions);
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