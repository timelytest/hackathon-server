package com.timelytest.hackathon.repository;

import com.timelytest.hackathon.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    @Query(value = "select * from answer where email = ?1",nativeQuery = true)
    List<Answer> findAllByEmail(String email);
}
