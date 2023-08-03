package com.example.okserver.service.jobService;

import com.example.okserver.domain.Job;
import com.example.okserver.packet.requestbody.GetDatelyRequestBody;
import com.example.okserver.packet.requestbody.GetMonthlyRequestBody;
import com.example.okserver.packet.requestbody.JobRequestBody;
import com.example.okserver.packet.responsebody.GetDatelyResponseBody;
import com.example.okserver.packet.responsebody.GetMonthlyResponseBody;
import com.example.okserver.packet.responsebody.JobResponseBody;
import com.example.okserver.packet.responsebody.UpdateJobResponseBody;
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
    public JobResponseBody createJob(Job job) {
        JobResponseBody responseBody = new JobResponseBody();
        if(!jobRepository.findByUserIdAndDate(job.getUserId(),job.getDate()).isPresent()){
            responseBody.setResult(false);
        }
        else{
            job.setMonth(job.getDate());
            job.setTotalHour(job.getStart(),job.getEnd());
            job.setTotalMoney(job.getMoney(), job.getTotalHour());

            jobRepository.save(job);
            responseBody.setResult(true);

        }
        return responseBody;
    }

    @Override
    public UpdateJobResponseBody updateJob(Job job) {
        return null;
    }

    @Override
    public JobResponseBody deleteJob(Job job) {
        JobResponseBody responseBody = new JobResponseBody();
        if(!jobRepository.findByUserIdAndDate(job.getUserId(),job.getDate()).isPresent()){
            jobRepository.delete(job);

        }
        else{
            responseBody.setResult(false);
        }

        return responseBody;
    }

    @Override
    public GetMonthlyResponseBody returnMonthlyJobList(GetMonthlyRequestBody requestBody) {
        GetMonthlyResponseBody responseBody = new GetMonthlyResponseBody();

        int month = requestBody.getMonth().getMonthValue();
        String userId = requestBody.getUserId();
        responseBody.setJobs(jobRepository.findByMonthAndUserId(month,userId));

        return responseBody;
    }

    @Override
    public GetDatelyResponseBody returnDatelyJobList(GetDatelyRequestBody requestBody) {
        return null;
    }
}
