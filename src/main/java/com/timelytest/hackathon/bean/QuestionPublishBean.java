package com.timelytest.hackathon.bean;

public class QuestionPublishBean {
    private String type;
    private String content;
    private String title;
    private double reward;

    public QuestionPublishBean() {
    }

    public QuestionPublishBean(String type, String content, String title, double reward) {
        this.type = type;
        this.content = content;
        this.title = title;
        this.reward = reward;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }
}
