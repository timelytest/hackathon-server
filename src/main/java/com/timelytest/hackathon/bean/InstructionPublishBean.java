package com.timelytest.hackathon.bean;

import java.util.Date;

public class InstructionPublishBean {
    // 请求者 email
    private String requesterEmail;
    // 指导者 email
    private String instructorEmail;
    // 指导学习内容的概况
    private String title;
    // 指导的详情
    private String content;
    // 请求发起的日期
    private Date date;
    // 预约的指导开始时间
    private Date startDate;
    // 报酬
    private double reward;

    public String getRequesterEmail() {
        return requesterEmail;
    }

    public void setRequesterEmail(String requesterEmail) {
        this.requesterEmail = requesterEmail;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }
}
