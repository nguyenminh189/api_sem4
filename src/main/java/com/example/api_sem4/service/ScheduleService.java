package com.example.api_sem4.service;

import com.example.api_sem4.dto.ScheduleDTO;
import com.example.api_sem4.entity.Schedule;
import com.example.api_sem4.entity.Subject;
import com.example.api_sem4.entity.Teacher;
import com.example.api_sem4.repository.ScheduleRepository;
import com.example.api_sem4.repository.SubjectRepository;
import com.example.api_sem4.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, SubjectRepository subjectRepository, TeacherRepository teacherRepository) {
        this.scheduleRepository = scheduleRepository;
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    // Lưu hoặc cập nhật lịch học
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // Lấy tất cả lịch học cho lớp học và ngày cụ thể
    public List<ScheduleDTO> getSchedulesByClassAndDay(Long classId, String dayOfWeek) {
        List<Schedule> schedules = scheduleRepository.findByClassIdAndDayOfWeek(classId, dayOfWeek);

        return schedules.stream().map(schedule -> {
            ScheduleDTO scheduleDTO = new ScheduleDTO();
            scheduleDTO.setId(schedule.getId());
            scheduleDTO.setClassId(schedule.getId());

            // Lấy tên môn học từ bảng Subject
            Optional<Subject> subject = subjectRepository.findById(Long.parseLong(schedule.getSubjectId()));
            subject.ifPresent(s -> scheduleDTO.setSubjectName(s.getName()));

            // Lấy tên giáo viên từ bảng Teacher
            Optional<Teacher> teacher = teacherRepository.findById(schedule.getTeacherId());
            teacher.ifPresent(t -> scheduleDTO.setTeacherName(t.getName()));

            scheduleDTO.setDayOfWeek(schedule.getDayOfWeek());
            scheduleDTO.setStartTime(schedule.getStartTime());
            scheduleDTO.setEndTime(schedule.getEndTime());
            return scheduleDTO;
        }).collect(Collectors.toList());
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
