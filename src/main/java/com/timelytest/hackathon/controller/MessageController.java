package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.entity.Message;
import com.timelytest.hackathon.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // 拉取未处理的消息
    public List<Message> getUnresolvedMessage(HttpSession session){
        return messageService.getUnresolvedMessage(session.getAttribute("email").toString());
    }

    // 查看详细的消息
    public Message getMessageById(int messageId){
        return messageService.getMessageById(messageId);
    }

    @PostMapping("/resolve")
    // ifAccept-对接单者-是否接收邀请
    // 一旦调用该方法表示 已读
    public String resolveAppoint(int messageId, int appointmentId, boolean ifAccept){
        return messageService.acceptAppoint(messageId, appointmentId, ifAccept);
    }

    @PostMapping("/adopt")
    // 采纳
    public String adoptAppoint(int messageId, int appointmentId){
        return messageService.adoptAppoint(messageId, appointmentId);
    }

}
