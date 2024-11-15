package com.paras.question_service.service;


import com.paras.question_service.dao.QuestionDao;
import com.paras.question_service.model.Question;
import com.paras.question_service.model.QuestionWrapper;
import com.paras.question_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;
    public List<Question> getallQuestion()
    {
       return questionDao.findAll();

    }


    public List<Question> getQuestionByCategory(String category) 
    {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "succes";

    }

    public String UpdateQuestion(int id, Question question) {
        questionDao.save(question);
        return "Updated";
    }

    public String deleteQuestion(int id) {
        questionDao.deleteById(id);
        return "deleted";
    }

    public List<Integer> getQuestionForQuiz(String category, int numQuestion) {
        List<Integer> questions =questionDao.findRandomQuestionByCategory(category,numQuestion);
        return questions;
    }

    public List<QuestionWrapper> getQuestionFromId(List<Integer> questionIds) {
        List<Question> question=new ArrayList<>();
        List<QuestionWrapper> wrapper = new ArrayList<>();
        for(Integer id: questionIds)
        {
            question.add(questionDao.findById(id).get());
        }
        for(Question q : question)
        {
            QuestionWrapper wrappers = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            wrapper.add(wrappers);
        }
        return wrapper;

    }

    public Integer getScore(List<Response> response) {
        int right=0;
        for(Response i: response)
        {
           Question question = questionDao.findById(i.getId()).get();
            if (i.getResponse().equals(question.getRightAnswer()))
            {
                right++;

            }

        }
        return right;
    }
}
