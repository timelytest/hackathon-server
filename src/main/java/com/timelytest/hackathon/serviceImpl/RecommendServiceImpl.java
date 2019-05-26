package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.entity.Question;
import com.timelytest.hackathon.entity.User;
import com.timelytest.hackathon.repository.UserRepository;
import com.timelytest.hackathon.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendServiceImpl implements RecommendService {
    final UserRepository userRepository;
    @Autowired
    public RecommendServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public List<User> getTopRewordUserListOverall() {
        return userRepository.findTopReword();
    }

    @Override
    public List<User> getTopRewardUserListLocally(String email) {
        Optional<User> userOptional=userRepository.findByEmail(email);
        if(!userOptional.isPresent())
            return new ArrayList<>();
        return userRepository.findTopRewordBySchool(userOptional.get().getSchool());
    }

    @Override
    public List<Question> getLatestResolvedQuestionList() {
        return null;
    }
}
