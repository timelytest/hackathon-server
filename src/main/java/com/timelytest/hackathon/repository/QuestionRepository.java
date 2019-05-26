package com.timelytest.hackathon.repository;

import com.timelytest.hackathon.entity.Question;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository {
    @Query(value = "select * from question",nativeQuery = true)
    List<Question> findAll();
}
