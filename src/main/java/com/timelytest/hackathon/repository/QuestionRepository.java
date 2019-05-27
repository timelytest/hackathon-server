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
    @Query(value = "select * from question where type = ?1 and closed = ?2",nativeQuery = true)
    List<Question> findByTypeAndAndClosed(String type,boolean closed);
    @Query(value = "select * from question where title like %?1% and closed = ?2",nativeQuery = true)
    List<Question> findByKeyAndClosed(String key,boolean closed);
    @Query(value = "select * from question where email = ?1 order by date desc limit 10",nativeQuery = true)
    List<Question> findLatestByEmail(String email);
}
