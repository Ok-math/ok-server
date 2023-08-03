package com.example.okserver.repository;

import com.example.okserver.domain.Job;
import com.example.okserver.domain.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface JobInfoRepository extends JpaRepository<JobInfo, Long> {
    Optional<JobInfo> findByUserIdAndName(String userId, String name);
}
