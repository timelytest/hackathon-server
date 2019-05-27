package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.bean.AppointmentPublishBean;
import com.timelytest.hackathon.entity.Appointment;
import com.timelytest.hackathon.service.AppointmentService;
import com.timelytest.hackathon.tool.DateGetting;
import com.timelytest.hackathon.tool.FileSaving;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/publish")
    public String publish(HttpSession session, @RequestBody AppointmentPublishBean appointmentPublishBean, MultipartFile multipartFile){
        String email = session.getAttribute("email").toString();
        String fileUrl = new FileSaving().saveFile(multipartFile);
        return appointmentService.publish(email, appointmentPublishBean, fileUrl);
    }

    @PostMapping("/available")
    public List<Appointment> getAvailableAppointmentList(HttpSession session){
        String email = session.getAttribute("email").toString();
        String date = DateGetting.getDate();
        return appointmentService.getAvailableAppointmentList(email, date);
    }
    @PostMapping("/get")
    Appointment getAppointmentById(int appointmentId){
        return appointmentService.getAppointmentById(appointmentId);
    }
}
