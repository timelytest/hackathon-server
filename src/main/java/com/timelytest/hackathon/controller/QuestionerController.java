package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.bean.QuestionPublishBean;
import com.timelytest.hackathon.service.QuestionerService;
import com.timelytest.hackathon.tool.FileSaving;
import org.springframework.beans.factory.annotation.Autowired;
import com.timelytest.hackathon.entity.Question;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionerController {
    private final QuestionerService questionerService;
    @Autowired
    public QuestionerController(QuestionerService questionerService){
        this.questionerService=questionerService;
    }
    @PostMapping("/publish")
    public String publish(HttpSession session, String type, String content, String title, double reward, @RequestParam("file") MultipartFile multipartFile){
        String fileUrl=null;
        if (multipartFile != null) {
            FileSaving fileSaving = new FileSaving();
            fileUrl = fileSaving.saveFile(multipartFile);
        }
        QuestionPublishBean bean = new QuestionPublishBean(type, content, title, reward);
        return questionerService.publish(bean,session.getAttribute("email").toString(),fileUrl);
    }

    @PostMapping("/modify")
    // 修改问题
    public String modify(@RequestParam int questionId, String type, String content, String title, double reward, MultipartFile multipartFile) {
        QuestionPublishBean bean = new QuestionPublishBean(type, content, title, reward);
        String url=null;
        if (multipartFile != null){
            FileSaving fileSaving = new FileSaving();
            url = fileSaving.saveFile(multipartFile);
        }
        return questionerService.modify(questionId,bean,url);
    }

    @PostMapping("/adopt")
    // 采纳回答
    public String adopt(@RequestParam int questionId, @RequestParam  int answerId){
        return questionerService.adopt(questionId,answerId);
    }

    @PostMapping("/list/publish")
    // 查看发布过的问题
    public List<Question> getQuestionList(HttpSession session){
        String email = session.getAttribute("email").toString();
        return questionerService.getQuestionList(email);
    }
}
