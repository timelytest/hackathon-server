package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.entity.Answer;
import com.timelytest.hackathon.entity.Question;
import com.timelytest.hackathon.enumeration.Message;
import com.timelytest.hackathon.repository.AnswerRepository;
import com.timelytest.hackathon.repository.QuestionRepository;
import com.timelytest.hackathon.service.AnswerService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Question> getQuestionListByType(String type) {
        return questionRepository.findByTypeAndAndClosed(type,false);
    }

    @Override
    public List<Question> getQuestionListByRecommendation(String keyword) {
        return questionRepository.findByKeyAndClosed(keyword,false);
    }

    @Override
    public String answerQuestion(int questionId, String email, String content) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Answer answer = new Answer();
        answer.setQuestionId(questionId);
        answer.setEmail(email);
        answer.setAccepted(false);
        answer.setContent(content);
        answer.setDate(df.format(new Date()));
        answer.setAgreeNumber(0);

        try{
            answerRepository.save(answer);
        }catch (Exception e){
            return Message.FAIL.toString();
        }
        return Message.SUCCESS.toString();
    }

    @Override
    public List<Answer> getAnswerList(String email) {
        return answerRepository.findAllByEmail(email);
    }
}
