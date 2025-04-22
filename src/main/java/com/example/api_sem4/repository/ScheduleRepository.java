package com.example.api_sem4.repository;

import com.example.api_sem4.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByClassIdAndDayOfWeek(Long classId, String dayOfWeek);
}
