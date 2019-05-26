package com.timelytest.hackathon.repository;

import com.timelytest.hackathon.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
}
