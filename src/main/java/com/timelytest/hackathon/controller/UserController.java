package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.bean.RegisterBean;
import com.timelytest.hackathon.bean.UserContextBean;
import com.timelytest.hackathon.enumeration.Message;
import com.timelytest.hackathon.service.UserService;
import com.timelytest.hackathon.tool.FileSaving;
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
    public String register(String email, String username, String password, String school, String studentId, String grade, String major, @RequestParam(name = "file") MultipartFile file){
        String fileUrl = null;
        if (file != null) {
            FileSaving fileSaving = new FileSaving();
            fileUrl = fileSaving.saveFile(file);
        }
        System.out.println(fileUrl);
        RegisterBean bean = new RegisterBean(email, username, password, school, studentId, grade, major);
        return userService.register(bean, fileUrl);
    }


//    @PostMapping(value = "register")
//    public String register(@RequestParam(name = "image") MultipartFile file){
//        String fileUrl = null;
//        if (file != null) {
//            FileSaving fileSaving = new FileSaving();
//            fileUrl = fileSaving.saveFile(file);
//        }
//        System.out.println(fileUrl);
//        return fileUrl;
//    }

    @PostMapping (value = "login")
    public String login(HttpSession session, String email, String password){
        String result=userService.login(email,password);
        if(result.equals(Message.SUCCESS.toString())){
            session.setAttribute("email",email);
        }
        return userService.login(email,password);
    }


    @PostMapping(value = "context")
    public UserContextBean getUserContext(String email){
        return null;
    }
}
