package com.example.api_sem4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "menus")
@AllArgsConstructor
@NoArgsConstructor

public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day_of_week;

    private Date start_date;

    private Date end_date;

    private String breakfast;

    private String second_breakfast;

    private String lunch;

    private String dinner;

    private String second_dinner;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getSecond_breakfast() {
        return second_breakfast;
    }

    public void setSecond_breakfast(String second_breakfast) {
        this.second_breakfast = second_breakfast;
    }

    public String getSecond_dinner() {
        return second_dinner;
    }

    public void setSecond_dinner(String second_dinner) {
        this.second_dinner = second_dinner;
    }

}


