package com.hust.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageDto{

    /**
     * 病人id
     *
     */
    private String id;
    /**
     * json格式的数据
     * 一个阶段的所有部分中被选中的数据
     */
    private Map<String, Object> checkedCities;
    /**
     * json格式数据
     * 一个阶段的所有部分的所有备选数据
     */
    private Map<String, Object> cities;
    /**
     * json格式数据
     * 一个阶段的所有部分的选中数据的要输入的额外信息
     */
    private Map<String, Object> detailCities;
    /**
     * 阶段id
     */
    private int where;


    private String beginDate;

    private String beginTime;

}
