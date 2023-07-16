package com.example.okserver.service.jobService;

import com.example.okserver.domain.Job;
import com.example.okserver.packet.requestbody.GetDatelyRequestBody;
import com.example.okserver.packet.requestbody.GetMonthlyRequestBody;
import com.example.okserver.packet.requestbody.JobRequestBody;
import com.example.okserver.packet.responsebody.GetDatelyResponseBody;
import com.example.okserver.packet.responsebody.GetMonthlyResponseBody;
import com.example.okserver.packet.responsebody.JobResponseBody;

public interface JobService {
    public JobResponseBody createJob(Job job);
    public GetMonthlyResponseBody returnMonthlyJobList(GetMonthlyRequestBody requestBody);
    public GetDatelyResponseBody returnDatelyJobList(GetDatelyRequestBody requestBody);

}
