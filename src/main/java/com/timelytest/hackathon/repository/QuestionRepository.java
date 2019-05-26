package com.timelytest.hackathon.repository;

import com.timelytest.hackathon.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository  extends JpaRepository<Question, Integer> {
    @Query(value = "select * from question",nativeQuery = true)
    List<Question> findAll();
    @Query(value = "select * from question where email = ?1",nativeQuery = true)
    List<Question> findAllByEmail(String Email);
}
