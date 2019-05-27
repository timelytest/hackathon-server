package com.timelytest.hackathon.repository;

import com.timelytest.hackathon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where email = ?1",nativeQuery = true)
    Optional<User> findByEmail(String email);
    @Query(value = "select * from user where accepted = true order by reward DESC limit 10",nativeQuery = true)
    List<User> findTopReword();
    @Query(value = "select * from user where accepted = true and school = ?1 order by reward DESC limit 10",nativeQuery = true)
    List<User> findTopRewordBySchool(String school);
    @Query(value = "select * from user where username = ?1 order by reward DESC limit 10",nativeQuery = true)
    List<User> findByUsername(String username);
    @Query(value = "select * from user where school = ?1 order by reward DESC limit 10",nativeQuery = true)
    List<User> findBySchool(String school);
}
