package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.entity.Appointment;
import com.timelytest.hackathon.entity.Message;
import com.timelytest.hackathon.entity.User;
import com.timelytest.hackathon.enumeration.AppointmentState;
import com.timelytest.hackathon.repository.AppointmentRepository;
import com.timelytest.hackathon.repository.MessageRepository;
import com.timelytest.hackathon.repository.UserRepository;
import com.timelytest.hackathon.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public MessageServiceImpl(AppointmentRepository appointmentRepository, UserRepository userRepository, MessageRepository messageRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getUnresolvedMessage(String email) {
        return messageRepository.getUnresolvedMessage(email);
    }

    @Override
    public Message getMessageById(int messageId) {
        if(messageRepository.findById(messageId).isPresent())
            return messageRepository.findById(messageId).get();
        return new Message();
    }

    @Override
    public String acceptAppoint(int messageId, int appointmentId, boolean ifAccept) {
        if(messageRepository.findById(messageId).isPresent()){
            Message message = messageRepository.findById(messageId).get();
            message.setResolved(true);
            try{
                if(ifAccept){
                    Message m = new Message();
                    m.setResolved(false);
                    m.setAppointmentId(appointmentId);
                    m.setRequesterEmail(message.getRequesterEmail());
                    m.setInstructorEmail(message.getInstructorEmail());
                    if(!userRepository.findByEmail(message.getInstructorEmail()).isPresent())
                        return "FAIL";
                    String instructorName = userRepository.findByEmail(message.getInstructorEmail()).get().getUsername();
                    m.setInfo("用户  "+ instructorName +" 已经接受了您的指导请求！");
                    messageRepository.save(message);
                    messageRepository.save(m);
                    return "SUCCESS";
                }
            }catch (Exception e){
                return "FAIL";
            }
        }
        return "FAIL";
    }

    @Override
    public String adoptAppoint(int messageId, int appointmentId) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        if(!optionalAppointment.isPresent())
            return "FAIL";
        Appointment appointment = optionalAppointment.get();
        Optional<User> userOptional = userRepository.findByEmail(appointment.getInstructorEmail());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setReward(user.getReward() + appointment.getReward());
            userRepository.save(user);
            appointment.setAppointmentState(AppointmentState.ACHIEVED);
            appointmentRepository.save(appointment);
            return "SUCCESS";
        }
        return "FAIL";
    }
}
