package com.example.okserver.repository;

import com.example.okserver.domain.DayAndTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayAndTimeRepository extends JpaRepository<DayAndTime, Long> {
}
