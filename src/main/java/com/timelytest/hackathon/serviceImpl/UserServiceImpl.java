package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.bean.RegisterBean;
import com.timelytest.hackathon.entity.PasswordEntity;
import com.timelytest.hackathon.entity.User;
import com.timelytest.hackathon.enumeration.Message;
import com.timelytest.hackathon.repository.PasswordRepository;
import com.timelytest.hackathon.repository.UserRepository;
import com.timelytest.hackathon.service.UserService;
import com.timelytest.hackathon.tool.MD5Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final PasswordRepository passwordRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository,PasswordRepository passwordRepository){
        this.userRepository = userRepository;
        this.passwordRepository=passwordRepository;
    }


    @Override
    public String register(RegisterBean registerBean, String cardImageUrl) {
        Optional<User> optionalUser=userRepository.findByEmail(registerBean.getEmail());
        if(optionalUser.isPresent()){
            return Message.EXIST.toString();
        }else{
            User user=new User();
            user.setEmail(registerBean.getEmail());
            user.setUsername(registerBean.getUsername());
            user.setSchool(registerBean.getSchool());
            user.setStudentId(registerBean.getStudentId());
            user.setMajor(registerBean.getMajor());
            user.setCardImageUrl(cardImageUrl);
            user.setAccepted(false);
            try {
                userRepository.save(user);
            }catch (Exception e){
                return Message.FAIL.toString();
            }
            PasswordEntity passwordEntity=new PasswordEntity();
            passwordEntity.setEmail(registerBean.getEmail());
            MD5Password md5Password=new MD5Password();
            passwordEntity.setPassword(md5Password.getMD5(registerBean.getPassword()));
            passwordRepository.save(passwordEntity);
        }
        return Message.SUCCESS.toString();
    }

    @Override
    public String login(String email, String password) {
        Optional<PasswordEntity> optionalPasswordEntity=passwordRepository.findByEmail(email);
        if(!optionalPasswordEntity.isPresent()){
            return Message.FAIL.toString();
        }else{
            MD5Password md5Password=new MD5Password();
            if(!optionalPasswordEntity.get().getPassword().equals(md5Password.getMD5(password)))
                return Message.FAIL.toString();
        }
        return Message.SUCCESS.toString();
    }
}
