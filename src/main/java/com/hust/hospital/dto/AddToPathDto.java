package com.hust.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 从前端传入病人id
 * 再从所有病人中找病人信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToPathDto {

    private String id;

    private String date;

    private String time;

    private Map<String, Object> checkedCities;

    private Map<String, Object> cities;

    private Map<String, Object> detailCities;
}
