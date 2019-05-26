package com.timelytest.hackathon.repository;

import com.timelytest.hackathon.entity.Answer;
import com.timelytest.hackathon.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
}
