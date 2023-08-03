package com.example.okserver.packet.requestbody;

import com.example.okserver.domain.DayAndTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobInfoRequestBody {
    String userId;
    String name;
    Integer money;
    List<DayAndTime> dayAndTimes = new ArrayList<>();
}
