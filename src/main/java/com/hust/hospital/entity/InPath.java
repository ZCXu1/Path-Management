package com.hust.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author EdwardXu
 * @description 在路径中的病人
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InPath {
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
    private Integer status;
    /**
     * 入院日期
     */
    private LocalDate date;
    /**
     * 入院时间
     */
    private LocalTime time;
}
