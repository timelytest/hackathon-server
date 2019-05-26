package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.entity.Instruction;
import com.timelytest.hackathon.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instruction")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/list/accept")
    // 查看接受过的所有的指导请求
    public List<Instruction> getInstructorInstructionList(@RequestParam String email){
        return instructorService.getInstructorInstructionList(email);
    }

    @PostMapping("/accept")
    // 接受指导的请求
    public String acceptInstruction(@RequestParam int instructionId){
        return instructorService.acceptInstruction(instructionId);
    }
}
