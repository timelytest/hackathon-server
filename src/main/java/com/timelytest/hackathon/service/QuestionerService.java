package com.timelytest.hackathon.service;

import com.timelytest.hackathon.bean.QuestionPublishBean;
import org.springframework.stereotype.Service;

@Service
public interface QuestionerService {
    String publish(QuestionPublishBean questionPublishBean,String email);
}