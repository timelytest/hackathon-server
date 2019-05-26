package com.timelytest.hackathon.service;

import com.timelytest.hackathon.bean.AppointmentPublishBean;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService {
    String publish(String email, AppointmentPublishBean appointmentPublishBean, String url);
}
