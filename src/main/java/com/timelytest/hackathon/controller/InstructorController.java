package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.entity.Instruction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instruction")
public class InstructorController {
    @PostMapping("/list/accept")
    public List<Instruction> getInstructorInstructionList(@RequestParam String email){
        return null;
    }

    @PostMapping("/accept")
    public List<Instruction> acceptInstruction(@RequestParam String email){
        return null;
    }
}
