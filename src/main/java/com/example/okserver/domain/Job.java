package com.example.okserver.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//상속관계 고려해보기
public class Job {
    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String name;
    private int money;
    private LocalTime start;
    private LocalTime end;
    private LocalDate date;
    private Integer month;
    private Long totalHour;
    private Long totalMoney;

    public void setTotalHour(LocalTime start, LocalTime end) {
        this.totalHour = Duration.between(start, end).toMinutes();
    }
    public void setTotalMoney(int money, Long totalHour){
        double time = totalHour/60.0;
        this.totalMoney = (long)(money * time);
    }

    public void setMonth(LocalDate date) {
        this.month = date.getMonthValue();
    }

}
