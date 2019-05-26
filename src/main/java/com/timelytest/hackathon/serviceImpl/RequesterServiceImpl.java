package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.bean.InstructionPublishBean;
import com.timelytest.hackathon.entity.Instruction;
import com.timelytest.hackathon.repository.InstructionRepository;
import com.timelytest.hackathon.repository.UserRepository;
import com.timelytest.hackathon.service.RequesterService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class RequesterServiceImpl implements RequesterService {
    final InstructionRepository instructionRepository;
    final UserRepository userRepository;

    public RequesterServiceImpl(InstructionRepository instructionRepository, UserRepository userRepository) {
        this.instructionRepository = instructionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String publish(InstructionPublishBean instructionPublishBean, MultipartFile multipartFile) {
        return null;
    }

    @Override
    public String adopt(String email, int instructionId) {
        return null;
    }

    @Override
    public List<Instruction> getRequesterInstructionList(String email) {
        return null;
    }
}
