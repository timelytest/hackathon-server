package com.timelytest.hackathon.service;

import com.timelytest.hackathon.bean.RegisterBean;

public interface UserService {
    String register(RegisterBean registerBean,String cardImageId);
}
