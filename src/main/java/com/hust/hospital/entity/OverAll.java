package com.hust.hospital.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 每个患者的路径总览
 * @author EdwardXu
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverAll {
    /**
     * 病人id
     */
    private String patientId;

    /**
     * 0表示准备进行 1表示已完成 2表示正在进行
     */
    private int stageOne;

    private int stageTwo;

    private int stageThree;

    private int stageFour;

}
