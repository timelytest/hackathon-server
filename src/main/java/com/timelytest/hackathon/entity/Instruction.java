package com.timelytest.hackathon.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "instruction")
public class Instruction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int instructionId;
    // 请求者 email
    private String requesterEmail;
    // 指导者 email
    private String instructorEmail;
    // 指导学习的标题
    private String title;
    // 指导的详情
    private String content;
    // 请求发起的日期
    private Date date;
    // 预约的指导开始时间
    private Date startDate;
    // 预约的指导开结束时间
    private Date endDate;
    // 报酬
    private double reward;
    // 是否支付报酬
    private boolean closed;

    public Instruction() {
    }

    public Instruction(String requesterEmail, String instructorEmail, String title, String content, Date date, Date startDate, Date endDate, double reward, boolean closed) {
        this.requesterEmail = requesterEmail;
        this.instructorEmail = instructorEmail;
        this.title = title;
        this.content = content;
        this.date = date;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reward = reward;
        this.closed = closed;
    }

    public int getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(int instructionId) {
        this.instructionId = instructionId;
    }

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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
