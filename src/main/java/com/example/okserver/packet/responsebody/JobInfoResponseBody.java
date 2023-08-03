package com.example.okserver.packet.responsebody;

import lombok.Data;

@Data
public class JobInfoResponseBody {
    Long id;
    String name;
    boolean result;
}
