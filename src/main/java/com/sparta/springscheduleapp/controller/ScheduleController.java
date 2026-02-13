package com.sparta.springscheduleapp.controller;

import com.sparta.springscheduleapp.dto.ScheduleResponseDto;
import com.sparta.springscheduleapp.entity.Schedule;
import com.sparta.springscheduleapp.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(
            @RequestBody CreateScheduleRequest request) {

        ScheduleResponseDto schedule = scheduleService.createSchedule(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );

        return ResponseEntity.ok(schedule);
    }
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getSchedules() {
        return ResponseEntity.ok(scheduleService.getSchedules());
    }


}



