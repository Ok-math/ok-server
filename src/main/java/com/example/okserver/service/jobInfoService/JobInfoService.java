package com.example.okserver.service.jobInfoService;

import com.example.okserver.packet.requestbody.JobInfoRequestBody;
import com.example.okserver.packet.responsebody.JobInfoResponseBody;

public interface JobInfoService {
    JobInfoResponseBody save_info(JobInfoRequestBody requestBody);
}
