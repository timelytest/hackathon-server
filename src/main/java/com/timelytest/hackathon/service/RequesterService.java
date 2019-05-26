package com.timelytest.hackathon.service;

import com.timelytest.hackathon.bean.InstructionPublishBean;
import com.timelytest.hackathon.entity.Instruction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequesterService {
    String publish(InstructionPublishBean instructionPublishBean, String path);
    String adopt(int instructionId);
    String cancel(int instructionId);
    List<Instruction> getRequesterInstructionList(String email);
}
