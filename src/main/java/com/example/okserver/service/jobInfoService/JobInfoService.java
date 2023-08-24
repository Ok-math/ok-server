package com.example.okserver.service.jobInfoService;

import com.example.okserver.packet.requestbody.JobInfoRequestBody;
import com.example.okserver.packet.responsebody.JobInfoResponseBody;

import java.util.ArrayList;

public interface JobInfoService {
    JobInfoResponseBody save_info(JobInfoRequestBody requestBody);
    ArrayList<String> show_names(String id);
}
