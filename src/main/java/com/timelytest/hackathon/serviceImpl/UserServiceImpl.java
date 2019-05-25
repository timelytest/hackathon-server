package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.entity.User;
import com.timelytest.hackathon.repository.UserRepository;
import com.timelytest.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public String login(String username, String password) {
        List<User> userList = userRepository.findAll();
        for(User user: userList){
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return "LoginSuccessfully!";
        }
        return "LoginFailed!";
    }
}
