package com.timelytest.hackathon.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String username;
    private String school;
    private String studentId;
    private String major;
    private int score;
    private int askPrestige;
    private int answerPrestige;

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getUserId() {
        return userId;
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

    public User() {
    }

    public User(String username, String school, String studentId, String major, int score, int askPrestige, int answerPrestige) {
        this.username = username;
        this.school = school;
        this.studentId = studentId;
        this.major = major;
        this.score = score;
        this.askPrestige = askPrestige;
        this.answerPrestige = answerPrestige;
    }
}
