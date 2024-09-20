package com.example.quizapp.service;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.Subject;
import com.example.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public interface SubjectService {

    List<Subject> getAllSubjects();

    void addSubject(Subject subject);

    void updateSubject(Long id, Subject updatedSubject);

}

