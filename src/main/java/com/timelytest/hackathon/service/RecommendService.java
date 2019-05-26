package com.timelytest.hackathon.service;

import com.timelytest.hackathon.entity.Question;
import com.timelytest.hackathon.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecommendService {

    List<User> getTopRewordUserListOverall();

    List<User> getTopRewardUserListLocally(String email);

    List<Question> getLatestResolvedQuestionList();
}
