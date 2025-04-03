package com.example.api_sem4.repository;

import com.example.api_sem4.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByClassIdAndDayOfWeek(Long classId, String dayOfWeek);
}
