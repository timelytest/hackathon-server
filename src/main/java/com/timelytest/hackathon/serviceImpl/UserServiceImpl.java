package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.bean.RegisterBean;
import com.timelytest.hackathon.bean.UserContextBean;
import com.timelytest.hackathon.entity.Appointment;
import com.timelytest.hackathon.entity.PasswordEntity;
import com.timelytest.hackathon.entity.User;
import com.timelytest.hackathon.enumeration.Message;
import com.timelytest.hackathon.repository.*;
import com.timelytest.hackathon.service.UserService;
import com.timelytest.hackathon.tool.MD5Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordRepository passwordRepository;
    private final QuestionRepository questionRepository;
    private final AppointmentRepository appointmentRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordRepository passwordRepository, QuestionRepository questionRepository, AppointmentRepository appointmentRepository, AnswerRepository answerRepository){
        this.userRepository = userRepository;
        this.passwordRepository=passwordRepository;
        this.questionRepository = questionRepository;
        this.appointmentRepository = appointmentRepository;
        this.answerRepository = answerRepository;
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

    @Override
    public UserContextBean getUserContext(String email) {
        Optional<User> optionalUser=userRepository.findByEmail(email);
        if(!optionalUser.isPresent())
            return new UserContextBean();
        User user = optionalUser.get();
        UserContextBean contextBean = new UserContextBean();
        contextBean.setUsername(user.getUsername());
        contextBean.setSchool(user.getSchool());
        contextBean.setStudentId(user.getStudentId());
        contextBean.setMajor(user.getMajor());
        contextBean.setQuestionNumber(questionRepository.findAllByEmail(email).size());
        contextBean.setAnswerNumber(answerRepository.findAllByEmail(email).size());
        contextBean.setRequestNumber(appointmentRepository.findAllByRequesterEmail(email).size());
        contextBean.setInstructNumber(appointmentRepository.findAllByInstructorEmail(email).size());
        contextBean.setLatestQuestionList(questionRepository.findLatestByEmail(email));
        contextBean.setLatestAnswerList(answerRepository.findLatestByEmail(email));
        return contextBean;
    }

    @Override
    public List<User> searchUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> searchUserBySchool(String school) {
        return userRepository.findBySchool(school);
    }
}
