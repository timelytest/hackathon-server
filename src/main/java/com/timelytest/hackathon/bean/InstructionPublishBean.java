package com.timelytest.hackathon.bean;

import java.util.Date;

public class InstructionPublishBean {
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
    // 报酬
    private double reward;
}
