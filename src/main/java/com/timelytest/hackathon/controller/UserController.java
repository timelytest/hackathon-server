package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.bean.RegisterBean;
import com.timelytest.hackathon.enumeration.Message;
import com.timelytest.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody RegisterBean registerBean){

        return null;
    }

    @PostMapping (value = "/login")
    public String login(HttpSession session,String email, String password){
//        String result=userService.login(email,password);
//        if(result.equals(Message.SUCCESS.toString())){
//            session.setAttribute("email",email);
//        }
//        return userService.login(email,password);
        return "SUCCESS";
    }

    @PostMapping(value = "/test")
    public String test(){
        return "hello world";
    }

}
