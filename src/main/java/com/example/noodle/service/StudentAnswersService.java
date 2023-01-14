package com.example.noodle.service;

import com.example.noodle.model.StudentAnswers;
import com.example.noodle.repo.StudentAnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentAnswersService {

    @Autowired
    StudentAnswersRepository answersRepository;

    public List<StudentAnswers> findAll(){
        return answersRepository.findAll();
    }

    public StudentAnswers saveAnswers(StudentAnswers answers) {

        return answersRepository.save(answers);
    }

    public List <StudentAnswers> findAnswersById(long id) {
        return answersRepository.findAnswersById(id);
    }

}
