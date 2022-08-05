package com.hust.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author EdwardXu
 * @description 病人
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient {

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



}
