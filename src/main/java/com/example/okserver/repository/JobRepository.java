package com.example.okserver.repository;

import com.example.okserver.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByMonthAndUserId(int month, String userId);

    Optional<Job> findByUserIdAndDate(String userId, LocalDate date);

}
