package com.example.okserver.service.jobService;

import com.example.okserver.packet.requestbody.GetDatelyRequestBody;
import com.example.okserver.packet.requestbody.GetMonthlyRequestBody;
import com.example.okserver.packet.responsebody.GetDatelyResponseBody;
import com.example.okserver.packet.responsebody.GetMonthlyResponseBody;

public interface JobService {
    public GetMonthlyResponseBody returnMonthlyJobList(GetMonthlyRequestBody requestBody);

    public GetDatelyResponseBody returnDatelyJobList(GetDatelyRequestBody requestBody);

}
