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
    // 指导学习内容的概况
    private String title;
    // 指导的详情
    private String content;
    // 请求发起的日期
    private Date date;
    // 预约的指导开始时间
    private Date startDate;
    // 指导结束时间（若为 null 则没有）
    private Date endDate;
    // 指导状态
    private InstructionState instructionState;
    // 报酬
    private double reward;
    // 是否支付报酬
    private boolean payed;

    public Instruction() {
    }

    public Instruction(String requesterEmail, String instructorEmail, String title, String content, Date date, Date startDate, Date endDate, InstructionState instructionState, double reward, boolean payed) {
        this.requesterEmail = requesterEmail;
        this.instructorEmail = instructorEmail;
        this.title = title;
        this.content = content;
        this.date = date;
        this.startDate = startDate;
        this.endDate = endDate;
        this.instructionState = instructionState;
        this.reward = reward;
        this.payed = payed;
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

    public InstructionState getInstructionState() {
        return instructionState;
    }

    public void setInstructionState(InstructionState instructionState) {
        this.instructionState = instructionState;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
}
