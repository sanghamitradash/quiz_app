package com.example.quizapp.ServiceImpl;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.Subject;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.SubjectRepository;
import com.example.quizapp.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public void addSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void updateSubject(Long id, Subject updatedSubject) {
        Subject existingSubject = subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Subject not found"));
        existingSubject.setSubjectName(updatedSubject.getSubjectName());
        subjectRepository.save(existingSubject);
    }
}
