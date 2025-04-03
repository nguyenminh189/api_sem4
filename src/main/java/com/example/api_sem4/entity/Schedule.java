package com.example.api_sem4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_id")
    private Long classId;  // ID lớp học (có thể liên kết với bảng `class`)

    @Column(name = "subject_id")
    private String subjectId;  // Mã môn học (có thể liên kết với bảng `subjects`)

    @Column(name = "teacher_id")
    private Long teacherId;  // ID giảng viên (có thể liên kết với bảng `teachers`)

    @Column(name = "day_of_week")
    private String dayOfWeek;  // Ngày trong tuần (1 - 7, tương ứng với các ngày từ Thứ 2 đến Chủ nhật)

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
