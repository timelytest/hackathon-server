package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.entity.Instruction;
import com.timelytest.hackathon.enumeration.InstructionState;
import com.timelytest.hackathon.enumeration.Message;
import com.timelytest.hackathon.repository.InstructionRepository;
import com.timelytest.hackathon.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructionRepository instructionRepository;

    @Autowired
    public InstructorServiceImpl(InstructionRepository instructionRepository) {
        this.instructionRepository = instructionRepository;
    }

    @Override
    public List<Instruction> getInstructorInstructionList(String email) {
        return instructionRepository.findAllByInstructorEmail(email);
    }

    @Override
    public String acceptInstruction(int instructionId) {
        Optional<Instruction> optionalInstruction = instructionRepository.findById(instructionId);
        if(optionalInstruction.isPresent()){
            Instruction instruction = optionalInstruction.get();
            instruction.setInstructionState(InstructionState.ONGOING);
            instructionRepository.save(instruction);
            return Message.SUCCESS.toString();
        }
        return Message.FAIL.toString();
    }
}
