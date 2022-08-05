package com.hust.hospital.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateDto {
    //proce == 0 继续本阶段
    //proce == 1 进入下一阶段
    //proce == 2 变异
    //proce == 3 完成路径
    private Integer proce;

    private String id;

    private String ground;

    private Integer stage;

    private LocalDate date;

    private LocalTime time;

}
