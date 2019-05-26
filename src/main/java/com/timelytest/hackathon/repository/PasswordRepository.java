package com.timelytest.hackathon.repository;

import com.timelytest.hackathon.entity.PasswordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<PasswordEntity, Integer> {
}
