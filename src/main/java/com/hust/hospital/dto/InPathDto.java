package com.hust.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InPathDto {
    /**
     * id
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 床号
     */
    private Integer bed;
    /**
     * 状态
     */
    private String status;
    /**
     * 入院日期
     * "yyyy-mm-dd"
     */
    private String date;
    /**
     * 入院时间
     * "hh::mm::ss"
     */
    private String time;

}
