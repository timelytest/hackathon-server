package com.timelytest.hackathon.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String email;
    private String username;
    private String school;
    private String studentId;
    private String major;
    private double reward;
    private double askPrestige;
    private double answerPrestige;
    private String cardImageUrl;
    private boolean accepted;
    public User(){}
    public User(String username, String school, String studentId, String major, double reward, double askPrestige, double answerPrestige, String cardImageUrl,String email,boolean accepted) {
        this.username = username;
        this.school = school;
        this.studentId = studentId;
        this.major = major;
        this.reward = reward;
        this.askPrestige = askPrestige;
        this.answerPrestige = answerPrestige;
        this.cardImageUrl = cardImageUrl;
        this.email=email;
        this.accepted=accepted;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public double getAskPrestige() {
        return askPrestige;
    }

    public void setAskPrestige(double askPrestige) {
        this.askPrestige = askPrestige;
    }

    public double getAnswerPrestige() {
        return answerPrestige;
    }

    public void setAnswerPrestige(double answerPrestige) {
        this.answerPrestige = answerPrestige;
    }

    public String getCardImageUrl() {
        return cardImageUrl;
    }

    public void setCardImageUrl(String cardImageUrl) {
        this.cardImageUrl = cardImageUrl;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
