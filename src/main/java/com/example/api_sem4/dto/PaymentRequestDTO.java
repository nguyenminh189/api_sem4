package com.example.api_sem4.dto;

import java.util.Date;

public class PaymentRequestDTO {
    private String name;
    private double tuitionFee;
    private double lunchFee;
    private double additionalFee;
    private Date deadlineDay;




    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getDeadlineDay() {
        return deadlineDay;
    }

    public void setDeadlineDay(Date deadlineDay) {
        this.deadlineDay = deadlineDay;
    }
}
