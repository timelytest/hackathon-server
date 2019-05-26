package com.timelytest.hackathon.service;

import com.timelytest.hackathon.bean.InstructionPublishBean;
import com.timelytest.hackathon.entity.Instruction;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RequesterService {
    String publish(InstructionPublishBean instructionPublishBean, MultipartFile multipartFile);
    String adopt(String email, int instructionId);
    List<Instruction> getRequesterInstructionList(String email);
}
