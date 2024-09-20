package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.Subject;
import com.example.quizapp.service.SubjectService;
import com.example.quizapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@PreAuthorize("hasRole('STUDENT')")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService questionService;

    @GetMapping("/allSubjects")
    public String getAllSubjects(Model model){
        List<Subject> subjects = studentService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "manage-subjects";
    }

    @GetMapping("/subject/{id}/questions")
    public String getQuestions(@PathVariable Long id, Model model){
        List<Question> questions = studentService.getQuestionsBySubjectId(id);
        model.addAttribute("questions", questions);
        return "questions";
    }

    @PostMapping("/submit-answers")
    public String submitAnswers(@RequestParam Map<String, String> answers, Principal principal){
        String studentUserName = principal.getName();
        studentService.processAnswers(answers, studentUserName);
        return "result";
    }
}
