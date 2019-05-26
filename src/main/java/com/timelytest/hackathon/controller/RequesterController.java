package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.bean.InstructionPublishBean;
import com.timelytest.hackathon.entity.Instruction;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/instruction")
public class RequesterController {
    @PostMapping("/publish")
    public String publish(@RequestBody InstructionPublishBean instructionPublishBean, MultipartFile multipartFile){
        return null;
    }

    @PostMapping("/adopt")
    public String adopt(@RequestParam String email, @RequestParam int instructionId){
        return null;
    }

    @PostMapping("/list/publish")
    public List<Instruction> getRequesterInstructionList(@RequestParam String email){
        return null;
    }
}
