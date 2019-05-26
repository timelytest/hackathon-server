package com.timelytest.hackathon.repository;

import com.timelytest.hackathon.entity.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstructionRepository extends JpaRepository<Instruction,Integer> {
    @Query(value = "select * from instruction where requesterEmail = ?1",nativeQuery = true)
    List<Instruction> findAllByRequesterEmail(String requesterEmail);
    @Query(value = "select * from instruction where instructorEmail = ?1",nativeQuery = true)
    List<Instruction> findAllByInstructorEmail(String instructorEmail);
}
