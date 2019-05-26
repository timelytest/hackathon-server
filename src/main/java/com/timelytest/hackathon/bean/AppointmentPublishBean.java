package com.timelytest.hackathon.bean;

import com.timelytest.hackathon.enumeration.AppointmentType;

public class AppointmentPublishBean {
    private String type;
    // 预约类型
    private AppointmentType appointmentType;
    // 问题详情
    private String content;
    // 问题标题
    private String title;
    // 有效日期
    private String effectiveDate;
    // 报酬
    private double reward;

    public AppointmentPublishBean(String type, AppointmentType appointmentType, String content, String title, String effectiveDate, double reward) {
        this.type = type;
        this.appointmentType = appointmentType;
        this.content = content;
        this.title = title;
        this.effectiveDate = effectiveDate;
        this.reward = reward;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }
}
