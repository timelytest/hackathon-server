package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.bean.QuestionPublishBean;
import com.timelytest.hackathon.entity.Question;
import com.timelytest.hackathon.enumeration.Message;
import com.timelytest.hackathon.repository.QuestionRepository;
import com.timelytest.hackathon.service.QuestionerService;
import com.timelytest.hackathon.tool.DateGetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionerServiceImpl implements QuestionerService {
    final QuestionRepository questionRepository;
    @Autowired
    public QuestionerServiceImpl(QuestionRepository questionRepository){
        this.questionRepository=questionRepository;
    }
    @Override
    public String publish(QuestionPublishBean questionPublishBean,String email) {
        Question question=new Question();
        question.setType(questionPublishBean.getType());
        question.setEmail(email);
        question.setContent(questionPublishBean.getContent());
        question.setTitle(questionPublishBean.getTitle());
        DateGetting dateGetting=new DateGetting();
        question.setDate(dateGetting.getDate());
        question.setReward(questionPublishBean.getReward());
        question.setClosed(false);
        try{
            questionRepository.save(question);
        }catch (Exception e){
            return Message.FAIL.toString();
        }
        return Message.SUCCESS.toString();
    }
}
