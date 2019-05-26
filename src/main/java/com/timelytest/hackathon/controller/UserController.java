package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.entity.User;
import com.timelytest.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("login")
    public String userLogin(@RequestParam String username, @RequestParam String password){
        //return userService.login(username, password);
        return "hello" + userService.login(username, password);
    }

    @PostMapping("logout")
    public String userLogout(/*@RequestParam String username, @RequestParam String password*/){
        //return userService.login(username, password);
        return "Logout!";
    }

    @GetMapping("get")
    public User getUser(){
//        return new User(123, "user", "pass");
        return  null;
    }
}
