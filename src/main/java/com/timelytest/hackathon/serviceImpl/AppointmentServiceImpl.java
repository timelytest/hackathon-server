package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.bean.AppointmentPublishBean;
import com.timelytest.hackathon.entity.Appointment;
import com.timelytest.hackathon.service.AppointmentService;
import com.timelytest.hackathon.tool.DateGetting;

public class AppointmentServiceImpl implements AppointmentService {

    @Override
    public String publish(String email, AppointmentPublishBean appointmentPublishBean, String url) {
        Appointment appointment=new Appointment();
        appointment.setAppointmentType(appointmentPublishBean.getAppointmentType());
        appointment.setType(appointmentPublishBean.getType());
        appointment.setEmail(email);
        appointment.setTitle(appointmentPublishBean.getTitle());
        appointment.setContent(appointmentPublishBean.getContent());
        DateGetting dateGetting=new DateGetting();
        appointment.setDate(dateGetting.getDate());
        appointment.setEffectiveDate(appointmentPublishBean.getEffectiveDate());
        appointment.setReward(appointmentPublishBean.getReward());
        appointment.setPath(url);
        
        return null;
    }

}
