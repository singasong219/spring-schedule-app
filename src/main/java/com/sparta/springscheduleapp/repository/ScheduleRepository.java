package com.sparta.springscheduleapp.repository;

import com.sparta.springscheduleapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}