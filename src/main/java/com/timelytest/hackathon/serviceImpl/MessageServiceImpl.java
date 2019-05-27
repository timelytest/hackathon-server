package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.entity.Message;
import com.timelytest.hackathon.repository.MessageRepository;
import com.timelytest.hackathon.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getUnresolvedMessage(String email) {
        return messageRepository.getUnresolvedMessage(email);
    }

    @Override
    public Message getMessageById(int messageId) {
        return null;
    }

    @Override
    public String acceptAppoint(int messageId, int appointmentId, boolean ifAccept) {
        return null;
    }

    @Override
    public String adoptAppoint(int messageId, int appointmentId) {
        return null;
    }
}
