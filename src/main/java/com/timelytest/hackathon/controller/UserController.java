package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.bean.RegisterBean;
import com.timelytest.hackathon.entity.User;
import com.timelytest.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "register")
    public String register(@RequestBody RegisterBean registerBean){

        return null;
    }
    @RequestMapping(value = "submit.assignment",method = RequestMethod.POST)
    public boolean submitAssignment(@RequestParam("file") MultipartFile[] multipartFiles){

        return false;
    }


}
