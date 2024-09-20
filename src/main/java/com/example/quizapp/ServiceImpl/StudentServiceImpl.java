package com.example.quizapp.ServiceImpl;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.StudentMarks;
import com.example.quizapp.model.Subject;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.StudentMarksRepository;
import com.example.quizapp.repository.SubjectRepository;
import com.example.quizapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private StudentMarksRepository studentMarksRepository;

    @Override
    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    @Override
    public List<Question> getQuestionsBySubjectId(Long subjectId) {
        return questionRepository.findBySubjectId(subjectId);
    }

    @Override
    public void processAnswers(Map<String, String> answers, String studentUserName) {
        int totalMarks = 0;

        for(Map.Entry<String, String> entry : answers.entrySet()){
            String questionId = entry.getKey();
            String selectedOption = entry.getValue();

            Question question = questionRepository.findById(Long.parseLong(questionId)).orElseThrow();
            if(question.getRightAnswer().equals(selectedOption)){
                totalMarks += question.getMarks();
            }

            //save marks for the student
            StudentMarks studentMarks = new StudentMarks();
            studentMarks.setUserName(studentUserName);
            studentMarks.setMarks(totalMarks);
            studentMarksRepository.save(studentMarks);

        }
    }

}
