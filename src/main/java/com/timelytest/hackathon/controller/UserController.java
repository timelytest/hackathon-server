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
    public String register(@RequestBody RegisterBean registerBean){
        return userService.register(registerBean,"");
    }


    /*@PostMapping(value = "register")
    public String register(@RequestParam(name = "image") MultipartFile file){
        String fileUrl = null;
        if (file != null) {
            FileSaving fileSaving = new FileSaving();
            fileUrl = fileSaving.saveFile(file);
        }
        System.out.println(fileUrl);
        return fileUrl;
    }

    @GetMapping (value = "login")
    public String login(HttpSession session,String email, String password){
        String result=userService.login(email,password);
        if(result.equals(Message.SUCCESS.toString())){
            session.setAttribute("email",email);
        }
        return userService.login(email,password);
    }


    @PostMapping(value = "/context")
    public UserContextBean getUserContext(HttpSession session){
        return userService.getUserContext(session.getAttribute("email").toString());
    }

    @PostMapping(value = "/search/username")
    public List<User> searchUserByUsername(String username){
        return userService.searchUserByUsername(username);
    }

    @PostMapping(value = "/search/school")
    public List<User> searchUserBySchool(String school){
        return userService.searchUserBySchool(school);
    }
}
