package com.timelytest.hackathon.service;

import com.timelytest.hackathon.bean.AppointmentPublishBean;
import com.timelytest.hackathon.entity.Appointment;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public interface AppointmentService {
    String publish(String email, AppointmentPublishBean appointmentPublishBean, String url);
    List<Appointment> getAvailableAppointmentList(String email, String date);
    Appointment getAppointmentById(int appointmentId);
    String accept(String email, int appointmentId);
    String adopt(int appointmentId);
}
