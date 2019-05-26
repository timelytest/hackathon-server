package com.timelytest.hackathon.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;
    // 问题所属专业分类
    private String type;
    // 提问者email
    private String email;
    // 问题详情
    private String content;
    // 问题标题
    private String title;
    // 提问日期
    private String date;
    // 报酬
    private double reward;
    // 问题已结束
    private boolean closed;
    //附件路径
    private String path;

    public Question() {
    }

    public Question(String type, String email, String content, String title, String date, double reward, boolean closed,String path) {
        this.type = type;
        this.email = email;
        this.content = content;
        this.title = title;
        this.date = date;
        this.reward = reward;
        this.closed = closed;
        this.path=path;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
