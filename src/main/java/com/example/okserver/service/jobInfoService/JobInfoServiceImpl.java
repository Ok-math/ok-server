package com.example.okserver.service.jobInfoService;


import com.example.okserver.domain.DayAndTime;
import com.example.okserver.domain.JobInfo;
import com.example.okserver.packet.requestbody.JobInfoRequestBody;
import com.example.okserver.packet.responsebody.JobInfoResponseBody;
import com.example.okserver.repository.DayAndTimeRepository;
import com.example.okserver.repository.JobInfoRepository;
import com.example.okserver.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobInfoServiceImpl implements JobInfoService{

    private final JobInfoRepository jobInfoRepository;
    private final DayAndTimeRepository dayAndTimeRepository;

    public JobInfoServiceImpl(JobInfoRepository jobInfoRepository,DayAndTimeRepository dayAndTimeRepository) {
        this.jobInfoRepository = jobInfoRepository;
        this.dayAndTimeRepository = dayAndTimeRepository;
    }
    @Override
    public JobInfoResponseBody save_info(JobInfoRequestBody requestBody) {
        JobInfo jobInfo = new JobInfo();
        List<DayAndTime> dayAndTime = new ArrayList<>();
        JobInfoResponseBody responseBody = new JobInfoResponseBody();

        if(!jobInfoRepository.findByUserIdAndName(requestBody.getUserId(),requestBody.getName()).isPresent()){
            //save
            jobInfo.setName(requestBody.getName());
            jobInfo.setMoney(requestBody.getMoney());
            jobInfo.setUserId(requestBody.getUserId());
            //jobInfo.setDayAndTimes(requestBody.getDayAndTimes());
            dayAndTime = requestBody.getDayAndTimes();
            jobInfoRepository.save(jobInfo);
            for(DayAndTime day_time:dayAndTime){
                //jobInfo.addDayAndTime(day_time);
                day_time.setJobInfo(jobInfo);
                dayAndTimeRepository.save(day_time);

            }


            responseBody.setId(jobInfo.getId());
            responseBody.setName(jobInfo.getName());
            responseBody.setResult(true);
        }
        else{
            //이미 동일명의 알바 존재
            responseBody.setResult(false);
        }

        return responseBody;
    }
}
