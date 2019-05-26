package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.bean.QuestionPublishBean;
import com.timelytest.hackathon.entity.Answer;
import com.timelytest.hackathon.entity.Question;
import com.timelytest.hackathon.entity.User;
import com.timelytest.hackathon.enumeration.Message;
import com.timelytest.hackathon.repository.AnswerRepository;
import com.timelytest.hackathon.repository.QuestionRepository;
import com.timelytest.hackathon.repository.UserRepository;
import com.timelytest.hackathon.service.QuestionerService;
import com.timelytest.hackathon.tool.DateGetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionerServiceImpl implements QuestionerService {
    final QuestionRepository questionRepository;
    final AnswerRepository answerRepository;
    final UserRepository userRepository;
    @Autowired
    public QuestionerServiceImpl(QuestionRepository questionRepository,AnswerRepository answerRepository,UserRepository userRepository){
        this.questionRepository=questionRepository;
        this.answerRepository=answerRepository;
        this.userRepository=userRepository;
    }
    @Override
    public String publish(QuestionPublishBean questionPublishBean,String email,String fileUrl) {
        Question question=new Question();
        question.setType(questionPublishBean.getType());
        question.setEmail(email);
        question.setContent(questionPublishBean.getContent());
        question.setTitle(questionPublishBean.getTitle());
        DateGetting dateGetting=new DateGetting();
        question.setDate(dateGetting.getDate());
        question.setReward(questionPublishBean.getReward());
        question.setClosed(false);
        question.setPath(fileUrl);
        try{
            questionRepository.save(question);
        }catch (Exception e){
            return Message.FAIL.toString();
        }
        return Message.SUCCESS.toString();
    }

    @Override
    public String modify(int questionId, QuestionPublishBean questionPublishBean,String fileUrl) {
        Optional<Question> optionalQuestion=questionRepository.findById(questionId);
        if(!optionalQuestion.isPresent()){
            return Message.FAIL.toString();
        }else{
            optionalQuestion.get().setType(questionPublishBean.getType());
            optionalQuestion.get().setContent(questionPublishBean.getContent());
            optionalQuestion.get().setTitle(questionPublishBean.getTitle());
            optionalQuestion.get().setReward(questionPublishBean.getReward());
            optionalQuestion.get().setPath(fileUrl);
            try {
                questionRepository.save(optionalQuestion.get());
            }catch (Exception e){
                return Message.FAIL.toString();
            }
        }
        return Message.SUCCESS.toString();
    }

    @Override
    public List<Question> getQuestionList(String email) {
        return questionRepository.findAllByEmail(email);
    }

    @Override
    public String adopt(int questionId, int answerId) {
        Optional<Question> questionOptional=questionRepository.findById(questionId);
        if(!questionOptional.isPresent()){
            return Message.FAIL.toString();
        }else {
            questionOptional.get().setAnswerId(answerId);
            try {
                questionRepository.save(questionOptional.get());
            }catch (Exception e){
                return Message.FAIL.toString();
            }
            //问题完成并发放奖励
            Optional<Answer> answerOptional=answerRepository.findById(answerId);
            if(!answerOptional.isPresent())
                return Message.FAIL.toString();
            answerOptional.get().setAccepted(true);//改状态
            try {
                answerRepository.save(answerOptional.get());
            }catch (Exception e){
                return Message.FAIL.toString();
            }
            String email=answerOptional.get().getEmail();
            Optional<User> userOptional=userRepository.findByEmail(email);
            if(!userOptional.isPresent())
                return Message.FAIL.toString();
            userOptional.get().setReward(questionOptional.get().getReward()+userOptional.get().getReward());//加奖励
            try{
                userRepository.save(userOptional.get());
            }catch (Exception e){
                return Message.FAIL.toString();
            }

        }
        return Message.SUCCESS.toString();
    }
}
