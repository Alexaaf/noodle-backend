package com.example.noodle.controller;

import com.example.noodle.model.Answers;
import com.example.noodle.model.StudentAnswers;
import com.example.noodle.service.AnswersService;
import com.example.noodle.service.StudentAnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentAnswers")
@CrossOrigin
public class StudentAnswersController {

    @Autowired
    StudentAnswersService answersService;
    @Autowired
    AnswersService corectAnswersService;


    @GetMapping(value = "/test")
    public ResponseEntity<String> getPage(){
        return new ResponseEntity<String>("Welcome", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<StudentAnswers> getAnswers(){
        return  answersService.findAll();
    }


    @PostMapping(value = "/addAnswers")
    public String addAnswers(@RequestBody StudentAnswers answers)
    {
        try{
            System.out.println("AICI ESTI COAIE" + answers.toString());
            System.out.println(corectAnswersService.findAnswersByQuizId(answers.getQuizId()));
            answersService.saveAnswers(answers);
            return "New answers added";
        }catch (Exception e)
        {
            System.out.println(e.toString());
            return e.toString();
        }

    }

    @RequestMapping (value = "findByStudentId/{id}")
    public List<StudentAnswers> getAnswersById(@PathVariable int id){
        return answersService.findAnswersById(id);
    }

}
