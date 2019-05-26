package com.timelytest.hackathon.entity;

import com.timelytest.hackathon.enumeration.AcceptorState;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Acceptor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int acceptorId;
    private int appointmentId;
    private String email;
    private String acceptDate;
    private AcceptorState acceptorState;

    public Acceptor() {
    }

    public Acceptor(int appointmentId, String email, String acceptDate, AcceptorState acceptorState) {
        this.appointmentId = appointmentId;
        this.email = email;
        this.acceptDate = acceptDate;
        this.acceptorState = acceptorState;
    }

    public int getAcceptorId() {
        return acceptorId;
    }

    public void setAcceptorId(int acceptorId) {
        this.acceptorId = acceptorId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    public AcceptorState getAcceptorState() {
        return acceptorState;
    }

    public void setAcceptorState(AcceptorState acceptorState) {
        this.acceptorState = acceptorState;
    }
}
