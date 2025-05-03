package com.example.api_sem4.dto;

import java.util.Date;

public class PaymentResponseDTO {
    private Long id;
    private String month;
    private double tuitionFee;
    private double lunchFee;
    private double additionalFee;
    private double totalFee;
    private Date deadlineDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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
