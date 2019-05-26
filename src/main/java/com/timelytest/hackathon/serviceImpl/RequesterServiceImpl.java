package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.bean.InstructionPublishBean;
import com.timelytest.hackathon.entity.Instruction;
import com.timelytest.hackathon.entity.User;
import com.timelytest.hackathon.enumeration.InstructionState;
import com.timelytest.hackathon.enumeration.Message;
import com.timelytest.hackathon.repository.InstructionRepository;
import com.timelytest.hackathon.repository.UserRepository;
import com.timelytest.hackathon.service.RequesterService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequesterServiceImpl implements RequesterService {
    private final InstructionRepository instructionRepository;
    private final UserRepository userRepository;

    public RequesterServiceImpl(InstructionRepository instructionRepository, UserRepository userRepository) {
        this.instructionRepository = instructionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String publish(InstructionPublishBean instructionPublishBean, String path) {
        Optional<User> optionalUser = userRepository.findByEmail(instructionPublishBean.getRequesterEmail());
        if(!optionalUser.isPresent())
            return Message.FAIL.toString();
        User user = optionalUser.get();
        if(user.getReward() < instructionPublishBean.getReward())
            return Message.BALANCE_NOT_ENOUGH.toString();
        user.setReward(optionalUser.get().getReward() - instructionPublishBean.getReward());
        userRepository.save(optionalUser.get());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Instruction instruction = new Instruction();
        instruction.setPath(path);
        instruction.setRequesterEmail(instructionPublishBean.getRequesterEmail());
        instruction.setInstructorEmail(instructionPublishBean.getRequesterEmail());
        instruction.setTitle(instructionPublishBean.getTitle());
        instruction.setContent(instructionPublishBean.getContent());
        instruction.setDate(df.format(instruction.getDate()));
        instruction.setStartDate(df.format(instruction.getStartDate()));
        instruction.setEndDate(null);
        instruction.setInstructionState(InstructionState.WAIT);
        instruction.setReward(instructionPublishBean.getReward());
        instruction.setPayed(false);

        try{
            instructionRepository.save(instruction);
        }catch (Exception e){
            return Message.FAIL.toString();
        }

        return Message.SUCCESS.toString();
    }

    @Override
    public String adopt(int instructionId) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Optional<Instruction> optionalInstruction = instructionRepository.findById(instructionId);
        if(!optionalInstruction.isPresent()){
            return Message.FAIL.toString();
        }else {
            Instruction instruction = optionalInstruction.get();
            instruction.setInstructionState(InstructionState.ACHIEVED);
            instruction.setEndDate(df.format(new Date()));
            instruction.setPayed(true);

            Optional<User> optionalUser = userRepository.findByEmail(instruction.getRequesterEmail());
            if(optionalUser.isPresent()){
                User user = optionalUser.get();
                user.setReward(user.getReward() + instruction.getReward());
                userRepository.save(user);
            }
            return Message.FAIL.toString();
        }
    }

    @Override
    public String cancel(int instructionId) {
        Optional<Instruction> optionalInstruction = instructionRepository.findById(instructionId);
        if(optionalInstruction.isPresent()){
            Instruction instruction = optionalInstruction.get();
            Optional<User> optionalUser = userRepository.findByEmail(instruction.getRequesterEmail());
            if(optionalUser.isPresent()){
                User user = optionalUser.get();
                user.setReward(user.getReward() + instruction.getReward());
                userRepository.save(user);
                return Message.SUCCESS.toString();
            }
        }
        return Message.FAIL.toString();
    }

    @Override
    public List<Instruction> getRequesterInstructionList(String email) {
        return instructionRepository.findAllByRequesterEmail(email);
    }
}
