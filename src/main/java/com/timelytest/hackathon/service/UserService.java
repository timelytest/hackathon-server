package com.timelytest.hackathon.service;

import com.timelytest.hackathon.bean.RegisterBean;
import com.timelytest.hackathon.bean.UserContextBean;
import com.timelytest.hackathon.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String register(RegisterBean registerBean,String cardImageId);
    String login(String email,String password);
    UserContextBean getUserContext(String email);
    List<User> searchUserByUsername(String username);
    List<User> searchUserBySchool(String school);
}
