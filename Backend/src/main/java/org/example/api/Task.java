package org.example.api;

//package com.todo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Task {
    private int id;
    private String description;
    private String status;
    private Date startDate;
    private Date targetDate;

    // Getters and Setters
    @JsonProperty
    public int getId() {
        return id;
    }
    @JsonProperty
    public void setId(int id) {
        this.id = id;
    }
    @JsonProperty
    public String getDescription() {
        return description;
    }
    @JsonProperty
    public void setDescription(String description) {
        this.description = description;
    }
    @JsonProperty
    public String getStatus() {
        return status;
    }
    @JsonProperty
    public void setStatus(String status) {
        this.status = status;
    }
    @JsonProperty
    public Date getStartDate() {
        return startDate;
    }
    @JsonProperty
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    @JsonProperty
    public Date getTargetDate() {
        return targetDate;
    }
    @JsonProperty
    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
}

