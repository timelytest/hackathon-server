package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.entity.Instruction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instruction")
public class InstructorController {
    @PostMapping("/list/accept")
    // 查看接受过的所有的指导请求
    public List<Instruction> getInstructorInstructionList(@RequestParam String email){
        return null;
    }

    @PostMapping("/accept")
    // 接受指导的请求
    public String acceptInstruction(@RequestParam String email, @RequestParam int instructionId){
        return null;
    }
}
