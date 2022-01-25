package com.dataload.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name = "DOSIS")
public class Dosis {

    @Id
    private Long id;
    @Column(name = "updated")
    private Date updated;
    @Column(name ="state")
    private String state;
    @Column(name ="totaldosis")
    private double totalDosis;
    @Column(name ="sessions")
    private double sessions;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public double getTotalDosis() {
        return totalDosis;
    }
    public void setTotalDosis(double totalDosis) {
        this.totalDosis = totalDosis;
    }
    public double getSessions() {
        return sessions;
    }
    public void setSessions(double sessions) {
        this.sessions = sessions;
    }

    
    
}
