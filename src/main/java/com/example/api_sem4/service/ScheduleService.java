package com.example.api_sem4.service;

import com.example.api_sem4.entity.Schedule;
import com.example.api_sem4.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // Lưu hoặc cập nhật lịch học
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // Lấy tất cả lịch học cho lớp học và ngày cụ thể
    public List<Schedule> getSchedulesByClassAndDay(Long classId, String dayOfWeek) {
        return scheduleRepository.findByClassIdAndDayOfWeek(classId, dayOfWeek);
    }

    // Lấy lịch học theo ID
    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    // Xóa lịch học theo ID
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
