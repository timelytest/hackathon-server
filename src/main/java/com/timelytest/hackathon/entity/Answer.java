package com.timelytest.hackathon.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int answerId;
    // 回答的问题 id
    private int questionId;
    // 回答者email
    private String email;
    // 回答是否被采纳
    private boolean accepted;
    // 回答详情
    private String content;
    // 回答日期
    private String date;
    // 回答赞同数量
    private int agreeNumber;

    public Answer() {
    }

    public Answer(int questionId, String email, boolean accepted, String content, String date, int agreeNumber) {
        this.questionId = questionId;
        this.email = email;
        this.accepted = accepted;
        this.content = content;
        this.date = date;
        this.agreeNumber = agreeNumber;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
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

    public int getAgreeNumber() {
        return agreeNumber;
    }

    public void setAgreeNumber(int agreeNumber) {
        this.agreeNumber = agreeNumber;
    }
}
