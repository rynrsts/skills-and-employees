package com.academy.week3group3final.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SkillDTO extends AuditModel {

    private Date createdAt;
    private Date updatedAt;
    private Long id;
    private String description;
    private int duration;
    private Date lastUsed;
    private Long employee_id;



    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLastUsed() {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        return DATE_FORMAT.format(lastUsed);
    }

    public void setLastUsed(String lastUsed) throws ParseException {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        this.lastUsed = DATE_FORMAT.parse(lastUsed);
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employeeId) {
        this.employee_id = employeeId;
    }

}
