package com.timelytest.hackathon.service;

import com.timelytest.hackathon.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    List<Message> getUnresolvedMessage(String email);
    Message getMessageById(int messageId);
    String acceptAppoint(int messageId, int appointmentId, boolean ifAccept);
    String adoptAppoint(int messageId, int appointmentId);
}
