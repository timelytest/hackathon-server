package com.timelytest.hackathon.service;

import com.timelytest.hackathon.entity.Answer;
import com.timelytest.hackathon.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService {
    List<Question> getQuestionListByType(String type);
    List<Question> getQuestionListByRecommendation(String keyword);
    String answerQuestion(int questionId, String email, String content);
    List<Answer> getAnswerList(String email);
}
