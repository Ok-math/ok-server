package com.example.okserver.packet.responsebody;


import com.example.okserver.domain.Job;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetMonthlyResponseBody {
    private List<Job> jobs = new ArrayList<>();
}
