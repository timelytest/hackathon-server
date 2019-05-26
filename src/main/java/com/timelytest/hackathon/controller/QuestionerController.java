package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.bean.QuestionPublishBean;
import com.timelytest.hackathon.entity.Question;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionerController {

    @PostMapping("/publish")
    // 发布问题
    public String publish(@RequestBody QuestionPublishBean questionPublishBean){
        return null;
    }

    @PostMapping("/modify")
    // 修改问题
    public String modify(@RequestParam int questionId, @RequestBody QuestionPublishBean questionPublishBean){
        return null;
    }

    @PostMapping("/adopt")
    // 采纳回答
    public String adopt(@RequestParam int questionId, @RequestParam  int answerId){
        return null;
    }

    @GetMapping("/list/publish")
    // 查看发布过的问题
    public List<Question> getQuestionList(@RequestParam String email){
        return null;
    }
}
