package com.example.okserver.packet.requestbody;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobRequestBody {
    private String userId;
    private String name;
    private Integer money;
    private LocalTime start;
    private LocalTime end;
    private LocalDate date;

}
