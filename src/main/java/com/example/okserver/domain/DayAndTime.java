package com.example.okserver.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "day_and_time")
public class DayAndTime {
    @Id
    @GeneratedValue
    private Long id;
    @JsonFormat(pattern = "kk:mm:ss", timezone = "Asia/Seoul")
    private LocalTime startTime;

    @JsonFormat(pattern = "kk:mm:ss", timezone = "Asia/Seoul")
    private LocalTime finishTime;
    private Day day;

    @ManyToOne
    @JoinColumn(name = "JOB_INFO_ID")
    private JobInfo jobInfo;


    public void setJobInfo(JobInfo jobInfo){
        if(this.jobInfo != null){
            this.jobInfo.getDayAndTimes().remove(this);
        }
        this.jobInfo = jobInfo;
        jobInfo.getDayAndTimes().add(this);

//        if(!jobInfo.getDayAndTimes().contains(this)){
//            jobInfo.addDayAndTime(this);
//        }

    }

}
enum Day {
    monday,
    tuesday,
    wednesday,
    thursday,
    friday,
    saturday,
    sunday
}




