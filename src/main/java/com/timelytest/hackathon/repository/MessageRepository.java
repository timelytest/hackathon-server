package com.timelytest.hackathon.repository;

import com.timelytest.hackathon.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    @Query(value = "select * from message where instructorEmail = ?1 and resolved = 0",nativeQuery = true)
    List<Message> getUnresolvedMessage(String email);


}
