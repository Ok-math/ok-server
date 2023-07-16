package com.example.okserver.packet.responsebody;

import com.example.okserver.domain.Job;
import lombok.Data;

import java.util.ArrayList;


@Data
public class GetDatelyResponseBody {
    private ArrayList<Job> jobs;
}
