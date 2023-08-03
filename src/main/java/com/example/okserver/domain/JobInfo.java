package com.example.okserver.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobInfo {
    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String name;
    private Integer money;

    @OneToMany(mappedBy = "jobInfo")
    private List<DayAndTime> dayAndTimes = new ArrayList<>();


    public void addDayAndTime(DayAndTime dayAndTime){
        this.dayAndTimes.add(dayAndTime);
        if(dayAndTime.getJobInfo() != this){
            dayAndTime.setJobInfo(this);
        }
    }

}




