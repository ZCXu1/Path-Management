package com.hust.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author EdwardXu
 * @description 返回给前端的OverAll列表的单项
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OverAllItemDto {

    private String stage;

    private String status;

    private int where;

    private String beginDate;

    private String beginTime;

    private String endDate;

    private String endTime;
}
