package com.example.okserver.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;

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

//    @OneToMany
//    @JoinColumn
//    private ArrayList<TimeAndDay> workingDay = new ArrayList<>();


}




