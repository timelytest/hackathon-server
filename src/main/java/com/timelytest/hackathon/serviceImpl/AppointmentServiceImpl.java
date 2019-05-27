package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.bean.AppointmentPublishBean;
import com.timelytest.hackathon.entity.Appointment;
import com.timelytest.hackathon.entity.User;
import com.timelytest.hackathon.enumeration.AppointmentState;
import com.timelytest.hackathon.enumeration.Message;
import com.timelytest.hackathon.repository.AppointmentRepository;
import com.timelytest.hackathon.repository.MessageRepository;
import com.timelytest.hackathon.repository.UserRepository;
import com.timelytest.hackathon.service.AppointmentService;
import com.timelytest.hackathon.tool.DateGetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, UserRepository userRepository, MessageRepository messageRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String publish(String email, AppointmentPublishBean appointmentPublishBean, String url) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(user.getReward() < appointmentPublishBean.getReward())
                return Message.BALANCE_NOT_ENOUGH.toString();
            user.setReward(user.getReward() - appointmentPublishBean.getReward());
            userRepository.save(user);
            Appointment appointment=new Appointment();
            appointment.setAppointmentType(appointmentPublishBean.getAppointmentType());
            appointment.setType(appointmentPublishBean.getType());
            appointment.setRequesterEmail(email);
            appointment.setTitle(appointmentPublishBean.getTitle());
            appointment.setContent(appointmentPublishBean.getContent());
            appointment.setDate(DateGetting.getDate());
            appointment.setEffectiveDate(appointmentPublishBean.getEffectiveDate());
            appointment.setReward(appointmentPublishBean.getReward());
            appointment.setPath(url);
            appointment.setAppointmentState(AppointmentState.WAIT);
            if(appointmentPublishBean.getInstructorEmail() != null && appointmentPublishBean.getInstructorEmail().length()>0) {
                appointment.setInstructorEmail(appointmentPublishBean.getInstructorEmail());
                appointment.setAppointmentState(AppointmentState.ONGOING);
            }
            appointmentRepository.save(appointment);
            return Message.SUCCESS.toString();
        }
        return Message.FAIL.toString();
    }

    @Override
    public List<Appointment> getAvailableAppointmentList(String email, String date) {
        List<Appointment> list = new ArrayList<>();
        List<Appointment> appointmentList = appointmentRepository.findAllByDateAfterAndEffectiveDateBefore(date);
        for(Appointment appointment: appointmentList){
            if(appointment.getAppointmentType().equals(AppointmentState.WAIT) && !appointment.getRequesterEmail().equals(email))
                list.add(appointment);
        }
        return list;
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        return optionalAppointment.orElse(null);
    }

    @Override
    public String accept(String email, int appointmentId) {
        Appointment appointment = getAppointmentById(appointmentId);
        appointment.setAppointmentState(AppointmentState.ONGOING);
        appointment.setInstructorEmail(email);
        appointmentRepository.save(appointment);
        return Message.SUCCESS.toString();
    }

    @Override
    public String adopt(int appointmentId) {
        Appointment appointment = getAppointmentById(appointmentId);
        Optional<User> userOptional = userRepository.findByEmail(appointment.getInstructorEmail());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setReward(user.getReward() + appointment.getReward());
            userRepository.save(user);
            appointment.setAppointmentState(AppointmentState.ACHIEVED);
            appointmentRepository.save(appointment);
            return Message.SUCCESS.toString();
        }
        return Message.FAIL.toString();
    }

}
