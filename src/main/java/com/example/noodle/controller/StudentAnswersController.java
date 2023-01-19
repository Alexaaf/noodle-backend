package com.example.noodle.controller;

import com.example.noodle.model.Answers;
import com.example.noodle.model.Grade;
import com.example.noodle.model.StudentAnswers;
import com.example.noodle.repo.GradeRepository;
import com.example.noodle.service.AnswersService;
import com.example.noodle.service.GradeService;
import com.example.noodle.service.StudentAnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/studentAnswers")
@CrossOrigin
public class StudentAnswersController extends Observable{

    @Autowired
    StudentAnswersService answersService;
    @Autowired
    AnswersService corectAnswersService;
    GradeService gradeService;
    GradeRepository gradeRepository;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();

    @GetMapping(value = "/test")
    public ResponseEntity<String> getPage(){
        return new ResponseEntity<String>("Welcome", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<StudentAnswers> getAnswers(){
        return  answersService.findAll();
    }


    @PostMapping(value = "/addAnswers")
    public Grade addAnswers(@RequestBody StudentAnswers answers){

            int grade = 0;
            List<String> studentAnswers = answers.convertToList(answers);
            List<Answers> an = corectAnswersService.findAnswersByQuizId(answers.getQuizId());
            System.out.println(an.toString());
            List<String> correctAnswers = an.get(0).convertToList(an.get(0));

            Iterator iteratorStudents = new AnswerIterator(studentAnswers);
            Iterator iteratorCorrectAns = new AnswerIterator(correctAnswers);
            //getCorrectAnswers
            while(iteratorStudents.hasNext()){
                String studentAnswer = (String) iteratorStudents.next();
                String correctAnswer = (String) iteratorCorrectAns.next();
                if (studentAnswer.equalsIgnoreCase(correctAnswer)){
                    grade++;
                }
            }
            //System.out.println(a);
            System.out.println(answers);

            //verifyAnswers and computeComputeGrade
            //if(a.get(0).getAnswer1().equals(answers.getAnswer1()))
              //  grade ++;

            System.out.println(grade);

            //add grade
            Grade g = new Grade();
            //g.setId(1L);
            g.setStudentID(String.valueOf(answers.getStudentId()));
            g.setDate(dtf.format(now));
            g.setGrade(String.valueOf(grade));
            g.setCourse(an.get(0).getCourse());

            System.out.println(g.toString());
            //gradeRepository.save(g);
            //gradeService.saveGrade(g);
            //saveAnswers
            //gradeService.saveGrade(g);
            answersService.saveAnswers(answers);
            return g;
    }

    @RequestMapping (value = "findByStudentId/{id}")
    public List<StudentAnswers> getAnswersById(@PathVariable int id){
        return answersService.findAnswersById(id);
    }

}
