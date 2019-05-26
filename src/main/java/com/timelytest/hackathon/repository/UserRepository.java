package com.timelytest.hackathon.repository;

import com.timelytest.hackathon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where email = ?1",nativeQuery = true)
    Optional<User> findByEmail(String email);
}
