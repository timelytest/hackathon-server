package com.timelytest.hackathon.entity;

import com.timelytest.hackathon.enumeration.InstructionState;

import javax.persistence.*;

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
    private String date;
    // 预约的指导开始时间
    private String startDate;
    // 指导结束时间（若为 null 则没有进行指导或指导尚未结束）
    private String endDate;
    // 指导状态
    private InstructionState instructionState;
    // 报酬
    private double reward;
    // 是否支付报酬
    private boolean payed;
    // 附件路径
    private String path;

    public Instruction() {
    }

    public Instruction(String requesterEmail, String instructorEmail, String title, String content, String date, String startDate, String endDate, InstructionState instructionState, double reward, boolean payed, String path) {
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
        this.path = path;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
