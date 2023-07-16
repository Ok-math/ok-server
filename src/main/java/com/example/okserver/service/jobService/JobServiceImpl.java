package com.example.okserver.service.jobService;

import com.example.okserver.packet.requestbody.GetDatelyRequestBody;
import com.example.okserver.packet.requestbody.GetMonthlyRequestBody;
import com.example.okserver.packet.responsebody.GetDatelyResponseBody;
import com.example.okserver.packet.responsebody.GetMonthlyResponseBody;
import com.example.okserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class JobServiceImpl implements JobService{
    private final UserRepository userRepository;

    public JobServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GetMonthlyResponseBody returnMonthlyJobList(GetMonthlyRequestBody requestBody) {
        GetMonthlyResponseBody responseBody = new GetMonthlyResponseBody();
        LocalDate date = requestBody.getMonth();
        return null;
    }

    @Override
    public GetDatelyResponseBody returnDatelyJobList(GetDatelyRequestBody requestBody) {
        return null;
    }
}
