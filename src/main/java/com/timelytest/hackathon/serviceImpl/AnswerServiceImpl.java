package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.entity.Answer;
import com.timelytest.hackathon.entity.Question;
import com.timelytest.hackathon.repository.QuestionRepository;
import com.timelytest.hackathon.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    final QuestionRepository questionRepository;
    @Autowired
    public AnswerServiceImpl(QuestionRepository questionRepository){
        this.questionRepository=questionRepository;
    }
    @Override
    public List<Question> getQuestionListByType(String type) {
        return questionRepository.findByTypeAndAndClosed(type,false);
    }

    @Override
    public List<Question> getQuestionListByRecommendation(String keywords) {
        return questionRepository.findByKeyAndClosed(keywords,false);
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
