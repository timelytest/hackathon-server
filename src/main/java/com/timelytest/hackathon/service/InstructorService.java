package com.timelytest.hackathon.service;

import com.timelytest.hackathon.entity.Instruction;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface InstructorService {
    List<Instruction> getInstructorInstructionList(String email);
    String acceptInstruction(int instructorId);
}
