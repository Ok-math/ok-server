package com.example.okserver.service.jobService;

import com.example.okserver.packet.requestbody.GetDatelyRequestBody;
import com.example.okserver.packet.requestbody.GetMonthlyRequestBody;
import com.example.okserver.packet.responsebody.GetDatelyResponseBody;
import com.example.okserver.packet.responsebody.GetMonthlyResponseBody;
import com.example.okserver.repository.JobRepository;
import com.example.okserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class JobServiceImpl implements JobService{
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public GetMonthlyResponseBody returnMonthlyJobList(GetMonthlyRequestBody requestBody) {
        GetMonthlyResponseBody responseBody = new GetMonthlyResponseBody();

        int month = requestBody.getDate().getMonthValue();
        String userId = requestBody.getUserId();
        responseBody.setJobs(jobRepository.findByMonthAndUserId(month,userId));

        return responseBody;
    }

    @Override
    public GetDatelyResponseBody returnDatelyJobList(GetDatelyRequestBody requestBody) {
        return null;
    }
}
