package com.paras.question_service.controller;


import com.paras.question_service.model.Question;
import com.paras.question_service.model.QuestionWrapper;
import com.paras.question_service.model.Response;
import com.paras.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionservice ;

    @GetMapping("/allquestion")
    public List<Question> getallQuestion()
    {
        return questionservice.getallQuestion();
    }
    @GetMapping("{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category)
    {
        return questionservice.getQuestionByCategory(category);
    }
    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question)
    {
        return questionservice.addQuestion(question);

    }
    @PutMapping("/update/{id}")
    public String UpdateQuestion(@PathVariable int id,@RequestBody Question question)
    {
        return questionservice.UpdateQuestion(id,question);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable int id )
    {
        return questionservice.deleteQuestion(id);
    }
    @GetMapping("generate")
    public List<Integer> getQuestionForQuiz(@RequestParam String category,@RequestParam int numQuestion)
    {
        return questionservice.getQuestionForQuiz(category,numQuestion);

    }
    @PostMapping("getQuestion")
    public List<QuestionWrapper> getQuestionFromId(@RequestBody List<Integer> questionIds )
    {
        return questionservice.getQuestionFromId(questionIds );
    }
    @PostMapping("getScore")
    public Integer getScore(@RequestBody List<Response> response)
    {
        return questionservice.getScore(response);
    }

}
/*
-microservices are an architectural style for developing software system that are made up of small independent, deployable service that
work together to provide a large functionality . Each microservice is designed to perform a specific task or communicates with Each other.

-In microservices architecture the application is broken down into a collection of loosely coupled services .
-Microservices can be implemented using a variety of programing language and framework and can be deployed on different platform . such as on-premise
server ,cloud infrastructure ,or container .
-On-premises and cloud computing are two different ways to host and mange software and data.

-cloud computing is a technology that allows user to access computing resource over the internet such as servers, storage , applications and services .



 */
