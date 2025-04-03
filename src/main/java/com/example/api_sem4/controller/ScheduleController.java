package com.example.api_sem4.controller;

import com.example.api_sem4.dto.ScheduleDTO;
import com.example.api_sem4.entity.Schedule;
import com.example.api_sem4.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    // Thêm hoặc cập nhật lịch học
    @PostMapping("/")
    public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule) {
        Schedule savedSchedule = scheduleService.saveSchedule(schedule);
        return ResponseEntity.ok(savedSchedule);
    }

    // Lấy tất cả lịch học cho lớp học và ngày trong tuần
    @GetMapping("/class/{classId}/day/{dayOfWeek}")
    public List<ScheduleDTO> getSchedulesByClassAndDay(@PathVariable Long classId, @PathVariable String dayOfWeek) {
        return scheduleService.getSchedulesByClassAndDay(classId, dayOfWeek);
    }

    // Lấy lịch học theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id) {
        Optional<Schedule> schedule = scheduleService.getScheduleById(id);
        if (schedule.isPresent()) {
            return ResponseEntity.ok(schedule.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Cập nhật lịch học theo ID
    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        Optional<Schedule> existingSchedule = scheduleService.getScheduleById(id);
        if (existingSchedule.isPresent()) {
            schedule.setId(id);  // Cập nhật ID
            Schedule updatedSchedule = scheduleService.saveSchedule(schedule);
            return ResponseEntity.ok(updatedSchedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa lịch học theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        Optional<Schedule> existingSchedule = scheduleService.getScheduleById(id);
        if (existingSchedule.isPresent()) {
            scheduleService.deleteSchedule(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
