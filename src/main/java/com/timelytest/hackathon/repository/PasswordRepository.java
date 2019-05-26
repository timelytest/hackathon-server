package com.timelytest.hackathon.repository;

import com.timelytest.hackathon.entity.PasswordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PasswordRepository extends JpaRepository<PasswordEntity, Integer> {
    @Query(value = "select * from password_entity where email = ?1",nativeQuery = true)
    Optional<PasswordEntity> findByEmail(String email);
}
