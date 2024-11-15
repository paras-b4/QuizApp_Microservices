package com.paras.quiz_service.feign;

import com.paras.quiz_service.model.QuestionWrapper;
import com.paras.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient("QUESTION-SERVICE")
public interface QuizInterface
{
    @GetMapping("question/generate")
    public List<Integer> getQuestionForQuiz(@RequestParam String category, @RequestParam int numQuestion);

    @PostMapping("question/getQuestion")
    public List<QuestionWrapper> getQuestionFromId(@RequestBody List<Integer> questionIds );

    @PostMapping("question/getScore")
    public Integer getScore(@RequestBody List<Response> response);

}
