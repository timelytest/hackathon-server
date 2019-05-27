package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.bean.AppointmentPublishBean;
import com.timelytest.hackathon.entity.Appointment;
import com.timelytest.hackathon.entity.User;
import com.timelytest.hackathon.enumeration.AppointmentState;
import com.timelytest.hackathon.enumeration.Message;
import com.timelytest.hackathon.repository.AppointmentRepository;
import com.timelytest.hackathon.repository.UserRepository;
import com.timelytest.hackathon.service.AppointmentService;
import com.timelytest.hackathon.tool.DateGetting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String publish(String email, AppointmentPublishBean appointmentPublishBean, String url) {
        Appointment appointment=new Appointment();
        appointment.setAppointmentType(appointmentPublishBean.getAppointmentType());
        appointment.setType(appointmentPublishBean.getType());
        appointment.setEmail(email);
        appointment.setTitle(appointmentPublishBean.getTitle());
        appointment.setContent(appointmentPublishBean.getContent());
        appointment.setDate(DateGetting.getDate());
        appointment.setEffectiveDate(appointmentPublishBean.getEffectiveDate());
        appointment.setReward(appointmentPublishBean.getReward());
        appointment.setPath(url);
        appointmentRepository.save(appointment);
        return Message.SUCCESS.toString();
    }

    @Override
    public List<Appointment> getAvailableAppointmentList(String email, String date) {
        List<Appointment> list = new ArrayList<>();
        List<Appointment> appointmentList = appointmentRepository.findAllByDateAfterAndEffectiveDateBefore(date);
        for(Appointment appointment: appointmentList){
            if(appointment.getAppointmentType().equals(AppointmentState.WAIT) && !appointment.getEmail().equals(email))
                list.add(appointment);
        }
        return list;
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        return optionalAppointment.orElse(null);
    }

}
