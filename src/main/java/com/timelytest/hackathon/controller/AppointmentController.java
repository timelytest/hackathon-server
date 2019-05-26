package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.bean.AppointmentPublishBean;
import com.timelytest.hackathon.bean.QuestionPublishBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @PostMapping("/publish")
    public String publish(HttpSession session, @RequestBody AppointmentPublishBean appointmentPublishBean, MultipartFile multipartFile){

        return null;
    }
}
