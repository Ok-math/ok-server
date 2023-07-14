package com.example.okserver.packet.responsebody;


import lombok.Data;

@Data
public class LoginResponseBody {
    private String id;
    private String password;
    private String name;
    private boolean result;
}
