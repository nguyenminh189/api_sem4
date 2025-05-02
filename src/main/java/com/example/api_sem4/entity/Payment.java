package com.example.api_sem4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "tuition_fee")
    private double tuitionFee;

    @Column(name = "lunch_fee")
    private double lunchFee;

    @Column(name = "additional_fee")
    private double additionalFee;

    @Column(name = "total_fee")
    private double totalFee;

    @Column(name = "deadline_day")
    private Date deadlineDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public double getLunchFee() {
        return lunchFee;
    }

    public void setLunchFee(double lunchFee) {
        this.lunchFee = lunchFee;
    }

    public double getAdditionalFee() {
        return additionalFee;
    }

    public void setAdditionalFee(double additionalFee) {
        this.additionalFee = additionalFee;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public Date getDeadlineDay() {
        return deadlineDay;
    }

    public void setDeadlineDay(Date deadlineDay) {
        this.deadlineDay = deadlineDay;
    }
}
