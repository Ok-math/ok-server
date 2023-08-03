package com.example.okserver.controller;


import com.example.okserver.packet.requestbody.JobInfoRequestBody;
import com.example.okserver.packet.responsebody.JobInfoResponseBody;
import com.example.okserver.service.jobInfoService.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/jobinfo")
public class JobInfoController {

    private JobInfoService jobInfoService;
    @Autowired  //
    public JobInfoController(JobInfoService jobInfoService){
        this.jobInfoService = jobInfoService;
    }



    @PostMapping("/save")
    JobInfoResponseBody jobInfo_save(@RequestBody JobInfoRequestBody requestBody){

        return jobInfoService.save_info(requestBody);
    }

}
