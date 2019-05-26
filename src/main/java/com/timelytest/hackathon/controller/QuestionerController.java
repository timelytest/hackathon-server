package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.bean.QuestionPublishBean;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/question")
public class QuestionerController {

    @PostMapping("/publish")
    public String publish(@RequestBody QuestionPublishBean questionPublishBean){
        return null;
    }

    @PostMapping("/adopt")
    public String adopt(int questionId, int answerId){
        return null;
    }
}
