package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.bean.QuestionPublishBean;
import com.timelytest.hackathon.service.QuestionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/question")
public class QuestionerController {
    private final QuestionerService questionerService;
    @Autowired
    public QuestionerController(QuestionerService questionerService){
        this.questionerService=questionerService;
    }
    @PostMapping("/publish")
    public String publish(HttpSession session,@RequestBody QuestionPublishBean questionPublishBean){
        return questionerService.publish(questionPublishBean,session.getAttribute("email").toString());
    }

    @PostMapping("/adopt")
    public String adopt(int questionId, int answerId){
        return null;
    }
}
