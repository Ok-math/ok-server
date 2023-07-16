package com.example.okserver.controller;


import com.example.okserver.packet.requestbody.GetDatelyRequestBody;
import com.example.okserver.packet.requestbody.GetMonthlyRequestBody;
import com.example.okserver.packet.responsebody.GetDatelyResponseBody;
import com.example.okserver.packet.responsebody.GetMonthlyResponseBody;
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

    @PostMapping
    public GetMonthlyResponseBody getMonthly(@RequestBody GetMonthlyRequestBody requestBody){
        return jobService.returnMonthlyJobList(requestBody);
    }

    @PostMapping("/date")
    public GetDatelyResponseBody getDately(@RequestBody GetDatelyRequestBody requestBody){
        return jobService.returnDatelyJobList(requestBody);
    }
}
