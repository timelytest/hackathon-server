package com.timelytest.hackathon.service;

import com.timelytest.hackathon.bean.RegisterBean;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String register(RegisterBean registerBean,String cardImageId);
    String login(String email,String password);
}
