package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.entity.Answer;
import com.timelytest.hackathon.entity.Question;
import com.timelytest.hackathon.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnswerController {
    private final AnswerService answerService;
    @Autowired
    public AnswerController(AnswerService answerService){
        this.answerService=answerService;
    }
    @PostMapping("/question/list/type")
    // 根据 type 为用户提供推荐的问题列表
    public List<Question> getQuestionListByType(@RequestParam String type){
        return answerService.getQuestionListByType(type);
    }

    @GetMapping("/question/list/recommendation")
    // 根据 key 为用户提供推荐的问题列表
    public List<Question> getQuestionListByRecommendation(@RequestParam String keywords){
        return answerService.getQuestionListByRecommendation(keywords);
    }

    @PostMapping("/question/answer")
    // 回答某个问题
    public String answerQuestion(@RequestParam int questionId, @RequestParam String email, @RequestParam String content){
        return null;
    }

    @PostMapping("/answer/list")
    // 查看所有回答过的问题
    public List<Answer> getAnswerList(@RequestParam String email){

        return new ArrayList<>();
    }
}
