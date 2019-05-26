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
    private int score;
    private int askPrestige;
    private int answerPrestige;
    private String cardImageUrl;
    private boolean accepted;
    public User(){}
    public User(String username, String school, String studentId, String major, int score, int askPrestige, int answerPrestige, String cardImageUrl,String email,boolean accepted) {
        this.username = username;
        this.school = school;
        this.studentId = studentId;
        this.major = major;
        this.score = score;
        this.askPrestige = askPrestige;
        this.answerPrestige = answerPrestige;
        this.cardImageUrl = cardImageUrl;
        this.email=email;
        this.accepted=accepted;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setAskPrestige(int askPrestige) {
        this.askPrestige = askPrestige;
    }

    public void setAnswerPrestige(int answerPrestige) {
        this.answerPrestige = answerPrestige;
    }

    public void setCardImageUrl(String cardImageUrl) {
        this.cardImageUrl = cardImageUrl;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getSchool() {
        return school;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public int getScore() {
        return score;
    }

    public int getAskPrestige() {
        return askPrestige;
    }

    public int getAnswerPrestige() {
        return answerPrestige;
    }

    public String getCardImageUrl() {
        return cardImageUrl;
    }

    public boolean isAccepted() {
        return accepted;
    }
}
