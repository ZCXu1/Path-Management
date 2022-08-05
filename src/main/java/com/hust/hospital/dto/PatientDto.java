package com.hust.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author EdwardXu
 * @description 和前端交互的patient格式
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientDto {
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

}
