package com.example.quizapp.ServiceImpl;

import com.example.quizapp.model.StudentMarks;
import com.example.quizapp.repository.StudentMarksRepository;
import com.example.quizapp.service.StudentMarksService;
import com.example.quizapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMarksServiceImpl implements StudentMarksService {

    @Autowired
    private StudentMarksRepository studentMarksRepository;
    @Override
    public List<StudentMarks> getAllStudentMarks() {
        return studentMarksRepository.findAll();
    }
}
