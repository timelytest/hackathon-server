package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.entity.Answer;
import com.timelytest.hackathon.entity.Question;
import com.timelytest.hackathon.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Override
    public List<Question> getQuestionListByType(String type) {
        return null;
    }

    @Override
    public List<Question> getQuestionListByRecommendation(String keywords) {
        return null;
    }

    @Override
    public String answerQuestion(int questionId, String email, String content) {
        return null;
    }

    @Override
    public List<Answer> getAnswerList(String email) {
        return null;
    }
}
