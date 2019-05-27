package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.bean.RegisterBean;
import com.timelytest.hackathon.bean.UserContextBean;
import com.timelytest.hackathon.entity.User;
import com.timelytest.hackathon.enumeration.Message;
import com.timelytest.hackathon.service.UserService;
import com.timelytest.hackathon.tool.FileSaving;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @PostMapping (value = "login")
    public String login(HttpSession session, String email, String password){
        String result=userService.login(email,password);
        if(result.equals(Message.SUCCESS.toString())){
            session.setAttribute("email",email);
        }
        return userService.login(email,password);
    }


    @PostMapping(value = "context")
    public UserContextBean getUserContext(HttpSession session){
        return null;
    }

    @PostMapping(value = "search")
    public List<User> searchUserByUsername(String username){
        return null;
    }

    @PostMapping(value = "search")
    public List<User> searchUserBySchool(String school){
        return null;
    }

}
