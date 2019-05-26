package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.entity.Answer;
import com.timelytest.hackathon.entity.Question;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {
    @PostMapping("/question/list/type")
    // 根据 type 为用户提供推荐的问题列表
    public List<Question> getQuestionListByType(@RequestParam String type){
        return null;
    }

    @PostMapping("/question/list/recommendation")
    // 根据 email 为用户提供推荐的问题列表
    public List<Question> getQuestionListByRecommendation(@RequestParam String email){
        return null;
    }

    @PostMapping("/question/answer")
    // 回答某个问题
    public String answerQuestion(@RequestParam int questionId, @RequestParam String email, @RequestParam String content){
        return null;
    }

    @PostMapping("/answer/list")
    // 查看所有回答过的问题
    public List<Answer> getAnswerList(@RequestParam String email){
        return null;
    }
}
