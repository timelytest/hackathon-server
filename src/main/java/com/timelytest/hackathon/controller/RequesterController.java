package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.bean.InstructionPublishBean;
import com.timelytest.hackathon.entity.Instruction;
import com.timelytest.hackathon.service.RequesterService;
import com.timelytest.hackathon.tool.FileSaving;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/instruction")
public class RequesterController {

    private final RequesterService requesterService;

    public RequesterController(RequesterService requesterService) {
        this.requesterService = requesterService;
    }

    @PostMapping("/publish")
    public String publish(@RequestBody InstructionPublishBean instructionPublishBean, MultipartFile multipartFile){
        String filePath = null;
        if(multipartFile != null){
            filePath = new FileSaving().saveFile(multipartFile);
        }
        return requesterService.publish(instructionPublishBean, filePath);
    }

    @PostMapping("/adopt")
    public String adopt(@RequestParam String email, @RequestParam int instructionId){
        return null;
    }

    @GetMapping("/list/publish")
    public List<Instruction> getRequesterInstructionList(@RequestParam String email){
        return null;
    }
}
