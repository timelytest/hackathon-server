package com.timelytest.hackathon.service;

import com.timelytest.hackathon.bean.QuestionPublishBean;
import com.timelytest.hackathon.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionerService {
    String publish(QuestionPublishBean questionPublishBean,String email,String fileUrl);
    String modify(int questionId,QuestionPublishBean questionPublishBean,String fileUrl);
    List<Question> getQuestionList(String email);
    String adopt(int questionId,int answerId);
}
