package com.sparta.springscheduleapp.service;

import com.sparta.springscheduleapp.dto.ScheduleResponseDto;
import com.sparta.springscheduleapp.entity.Schedule;
import com.sparta.springscheduleapp.repository.ScheduleRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // Lv2 전체 조회
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleRepository
                .findAll(Sort.by(Sort.Direction.DESC, "modifiedAt"))
                .stream()
                .map(ScheduleResponseDto::new)
                .collect(Collectors.toList());
    }

    // Lv1 일정 생성
    public ScheduleResponseDto createSchedule(
            String title, String content, String author, String password
    ) {
        Schedule schedule = new Schedule(title, content, author, password);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule);
    }
}