package com.example.okserver.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeAndDay {
    @Id
    @GeneratedValue
    @Column(name = "time_day_id")
    private Long id;
    private LocalTime startTime;
    private LocalTime finishTime;
    private Day day;

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




