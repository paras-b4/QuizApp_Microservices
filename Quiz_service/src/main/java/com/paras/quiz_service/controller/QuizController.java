package com.paras.quiz_service.controller;




import com.paras.quiz_service.model.QuestionWrapper;
import com.paras.quiz_service.model.Response;
import com.paras.quiz_service.model.quizDTO;
import com.paras.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController
{
    @Autowired
    private QuizService quizservice;
    @PostMapping("/create")
    public String CreateQuiz(@RequestBody quizDTO quizDTO)
    {
        return quizservice.CreateQuiz(quizDTO.getCategory(),quizDTO.getTitle(),quizDTO.getNumQuestion());
    }
    @GetMapping("/get/{id}")
    public List<QuestionWrapper> getQuizQuestion(@PathVariable int id)
    {
        return quizservice.getQuizQuestion(id);
    }
    @PostMapping("/submit/{id}")
    public Integer calculateResult(@PathVariable int id,@RequestBody List<Response> response)
    {
        return quizservice.calculateResult(id,response);

    }


}
