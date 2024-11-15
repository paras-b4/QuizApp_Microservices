package com.paras.quiz_service.service;
import com.paras.quiz_service.dao.QuizDao;
import com.paras.quiz_service.feign.QuizInterface;
import com.paras.quiz_service.model.Question;
import com.paras.quiz_service.model.QuestionWrapper;
import com.paras.quiz_service.model.Quiz;
import com.paras.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizDao quizdao;
    @Autowired
    QuizInterface quizInterface;

    public String CreateQuiz(String category, String title, int numQuestion) {

        List<Integer> questions=quizInterface.getQuestionForQuiz(category,numQuestion);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizdao.save(quiz);
        return "succes";

    }

    public List<QuestionWrapper> getQuizQuestion(int id)
    {
      Quiz quiz = quizdao.findById(id).get();
      List<Integer> question = quiz.getQuestionsIds();
      List<QuestionWrapper> wrapper  = quizInterface.getQuestionFromId(question);
      return wrapper;

    }
    public Integer calculateResult(int id, List<Response> response) {
      Integer score = quizInterface.getScore(response);
      return score;

    }
}

