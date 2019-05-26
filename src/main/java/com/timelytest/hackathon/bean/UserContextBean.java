package com.timelytest.hackathon.bean;

import com.timelytest.hackathon.entity.Answer;
import com.timelytest.hackathon.entity.Question;

import java.util.List;

public class UserContextBean {
    private String school;
    private String studentId;
    private String major;
    private int answerNumber;
    private int questionNumber;
    private double score;
    private List<Question> latestQuestionList;
    private List<Answer> latestAnswerList;

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
