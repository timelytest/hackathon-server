package com.timelytest.hackathon.bean;

import com.timelytest.hackathon.entity.Answer;
import com.timelytest.hackathon.entity.Question;

import java.util.ArrayList;
import java.util.List;

public class UserContextBean {
    private String username;
    private String school;
    private String studentId;
    private String major;
    // 回答总数
    private int answerNumber;
    // 提问总数
    private int questionNumber;
    // 发起appointment 次数
    private int requestNumber;
    // 接受appointment 次数
    private int instructNumber;
    private double score;
    private List<Question> latestQuestionList;
    private List<Answer> latestAnswerList;

    public UserContextBean() {
        this.latestQuestionList = new ArrayList<>();
        this.latestAnswerList = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public int getInstructNumber() {
        return instructNumber;
    }

    public void setInstructNumber(int instructNumber) {
        this.instructNumber = instructNumber;
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

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<Question> getLatestQuestionList() {
        return latestQuestionList;
    }

    public void setLatestQuestionList(List<Question> latestQuestionList) {
        this.latestQuestionList = latestQuestionList;
    }

    public List<Answer> getLatestAnswerList() {
        return latestAnswerList;
    }

    public void setLatestAnswerList(List<Answer> latestAnswerList) {
        this.latestAnswerList = latestAnswerList;
    }
}
