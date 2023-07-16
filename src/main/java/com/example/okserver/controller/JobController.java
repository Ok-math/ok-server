package com.example.okserver.controller;


import com.example.okserver.domain.Job;
import com.example.okserver.packet.requestbody.GetDatelyRequestBody;
import com.example.okserver.packet.requestbody.GetMonthlyRequestBody;
import com.example.okserver.packet.requestbody.JobRequestBody;
import com.example.okserver.packet.responsebody.GetDatelyResponseBody;
import com.example.okserver.packet.responsebody.GetMonthlyResponseBody;
import com.example.okserver.packet.responsebody.JobResponseBody;
import com.example.okserver.service.jobService.JobService;
import com.example.okserver.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/job")
public class JobController {
    private UserService userService;
    private JobService jobService;
    @Autowired  //
    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @PostMapping("/save")
    public JobResponseBody createJob(@RequestBody JobRequestBody requestBody){
        Job job = new Job();
        job.setUserId(requestBody.getUserId());
        job.setName(requestBody.getName());
        job.setDate(requestBody.getDate());
        job.setMoney(requestBody.getMoney());
        job.setStart(requestBody.getStart());
        job.setEnd(requestBody.getEnd());
        job.setDate(requestBody.getDate());
        return jobService.createJob(job);
    }


    @PostMapping
    public GetMonthlyResponseBody getMonthly(@RequestBody GetMonthlyRequestBody requestBody){
        return jobService.returnMonthlyJobList(requestBody);
    }

    @PostMapping("/date")
    public GetDatelyResponseBody getDately(@RequestBody GetDatelyRequestBody requestBody){
        return jobService.returnDatelyJobList(requestBody);
    }
}
