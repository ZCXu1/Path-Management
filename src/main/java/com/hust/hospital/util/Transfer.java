package com.hust.hospital.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hust.hospital.dto.InPathDto;
import com.hust.hospital.dto.OverAllItemDto;
import com.hust.hospital.dto.PatientDto;
import com.hust.hospital.entity.*;
import com.hust.hospital.entity.detail.Stage1;
import com.hust.hospital.entity.detail.Stage2;
import com.hust.hospital.entity.detail.Stage3;
import com.hust.hospital.entity.detail.Stage4;
import com.hust.hospital.service.InPathService;
import com.hust.hospital.service.StageService;
import com.hust.hospital.service.impl.InPathServiceImpl;
import com.hust.hospital.service.impl.StageServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Transfer {
    public static PatientDto patientToDto(Patient patient){
        String status = Status.getDescriptionById(patient.getStatus());
        return new PatientDto(patient.getId(),patient.getName(),patient.getBed(),status);
    }
    public static Patient dtoToPatient(PatientDto dto){
        int status = Status.getIdByDescription(dto.getStatus());
        return new Patient(dto.getId(),dto.getName(),dto.getBed(),status);
    }
    public static InPathDto inPathToDto(InPath patient){
        String status = Status.getDescriptionById(patient.getStatus());
        return new InPathDto(patient.getId(),patient.getName(),patient.getBed(),status,patient.getDate().toString(),patient.getTime().toString());
    }
    public static InPath dtoToInPath(InPathDto dto){
        int status = Status.getIdByDescription(dto.getStatus());
        return new InPath(dto.getId(),dto.getName(),dto.getBed(),status,LocalDate.parse(dto.getDate()), LocalTime.parse(dto.getTime()));
    }
    public static List<OverAllItemDto> overAllToDtos(OverAll overAll){
        StageService ss = new StageServiceImpl();
        List<OverAllItemDto> ret = new ArrayList<>();
        OverAllItemDto dto1 = new OverAllItemDto();
        dto1.setStage(Stage.ONE.getDescription());
        dto1.setStatus(StageStatus.getDescriptionById(overAll.getStageOne()));
        dto1.setWhere(Stage.ONE.getId());
        Stage1 s = ss.getStage1ById(overAll.getPatientId());
        if(s != null) {
            LocalDate beginDate1 = s.getBeginDate();
            LocalTime beginTime1 = s.getBeginTime();
            if (beginDate1 != null && beginTime1 != null) {
                dto1.setBeginDate(beginDate1.toString());
                dto1.setBeginTime(beginTime1.toString());
            } else {
                dto1.setBeginDate("null");
                dto1.setBeginTime("null");
            }
            LocalDate endDate1 = s.getEndDate();
            LocalTime endTime1 = s.getEndTime();
            if (endDate1 != null && endTime1 != null) {
                dto1.setEndDate(endDate1.toString());
                dto1.setEndTime(endTime1.toString());
            } else {
                dto1.setEndDate("null");
                dto1.setEndTime("null");
            }
        }
        ret.add(dto1);

        OverAllItemDto dto2 = new OverAllItemDto();
        dto2.setStage(Stage.TWO.getDescription());
        dto2.setStatus(StageStatus.getDescriptionById(overAll.getStageTwo()));
        dto2.setWhere(Stage.TWO.getId());

        if(overAll.getStageTwo() !=0 ) {
            Stage2 s2 = ss.getStage2ById(overAll.getPatientId());
            if (s2 != null) {
                LocalDate beginDate2 = s2.getBeginDate();
                LocalTime beginTime2 = s2.getBeginTime();
                if (beginDate2 != null && beginTime2 != null) {
                    dto2.setBeginDate(beginDate2.toString());
                    dto2.setBeginTime(beginTime2.toString());
                } else {
                    dto2.setBeginDate("null");
                    dto2.setBeginTime("null");
                }
                LocalDate endDate2 = s2.getEndDate();
                LocalTime endTime2 = s2.getEndTime();
                if (endDate2 != null && endTime2 != null) {
                    dto2.setEndDate(endDate2.toString());
                    dto2.setEndTime(endTime2.toString());
                } else {
                    dto2.setEndDate("null");
                    dto2.setEndTime("null");
                }
            }
        }
        ret.add(dto2);

        OverAllItemDto dto3 = new OverAllItemDto();
        dto3.setStage(Stage.THREE.getDescription());
        dto3.setStatus(StageStatus.getDescriptionById(overAll.getStageThree()));
        dto3.setWhere(Stage.THREE.getId());
        if(overAll.getStageThree() != 0) {
            Stage3 s3 = ss.getStage3ById(overAll.getPatientId());
            if (s3 != null) {
                LocalDate beginDate3 = s3.getBeginDate();
                LocalTime beginTime3 = s3.getBeginTime();
                if (beginDate3 != null && beginTime3 != null) {
                    dto3.setBeginDate(beginDate3.toString());
                    dto3.setBeginTime(beginTime3.toString());
                } else {
                    dto3.setBeginDate("null");
                    dto3.setBeginTime("null");
                }
                LocalDate endDate3 = s3.getEndDate();
                LocalTime endTime3 = s3.getEndTime();
                if (endDate3 != null && endTime3 != null) {
                    dto3.setEndDate(endDate3.toString());
                    dto3.setEndTime(endTime3.toString());
                } else {
                    dto3.setEndDate("null");
                    dto3.setEndTime("null");
                }
            }
        }
        ret.add(dto3);

        OverAllItemDto dto4 = new OverAllItemDto();
        dto4.setStage(Stage.FOUR.getDescription());
        dto4.setStatus(StageStatus.getDescriptionById(overAll.getStageFour()));
        dto4.setWhere(Stage.FOUR.getId());
        if(overAll.getStageFour()!=0) {
            Stage4 s4 = ss.getStage4ById(overAll.getPatientId());
            if (s4 != null) {
                LocalDate beginDate4 = s4.getBeginDate();
                LocalTime beginTime4 = s4.getBeginTime();
                if (beginDate4 != null && beginTime4 != null) {
                    dto4.setBeginDate(beginDate4.toString());
                    dto4.setBeginTime(beginTime4.toString());
                } else {
                    dto4.setBeginDate("null");
                    dto4.setBeginTime("null");
                }
                LocalDate endDate4 = s4.getEndDate();
                LocalTime endTime4 = s4.getEndTime();
                if (endDate4 != null && endTime4 != null) {
                    dto4.setEndDate(endDate4.toString());
                    dto4.setEndTime(endTime4.toString());
                } else {
                    dto4.setEndDate("null");
                    dto4.setEndTime("null");
                }
            }
        }
        ret.add(dto4);
        return ret;
    }
    public static JSONArray transferCheckedCities(JSONArray cityi,JSONArray initCityi){
        JSONArray newCityi = new JSONArray();
        for(Object o : initCityi){
            if (cityi.contains(o)){
                newCityi.add(o);
            }else{
                newCityi.add("");
            }
        }
        return newCityi;
    }

    public static void transferCheckedCities(JSONObject checkedCities,JSONObject cities){
        JSONArray city0 = checkedCities.getJSONArray("city0");
        JSONArray initCity0 = cities.getJSONArray("city0");
        JSONArray newCity0 = Transfer.transferCheckedCities(city0,initCity0);
        checkedCities.put("city0",newCity0);
        JSONArray city1 = checkedCities.getJSONArray("city1");
        JSONArray initCity1 = cities.getJSONArray("city1");
        JSONArray newCity1 = Transfer.transferCheckedCities(city1,initCity1);
        checkedCities.put("city1",newCity1);
        JSONArray city2 = checkedCities.getJSONArray("city2");
        JSONArray initCity2 = cities.getJSONArray("city2");
        JSONArray newCity2 = Transfer.transferCheckedCities(city2,initCity2);
        checkedCities.put("city2",newCity2);
        JSONArray city3 = checkedCities.getJSONArray("city3");
        JSONArray initCity3 = cities.getJSONArray("city3");
        JSONArray newCity3 = Transfer.transferCheckedCities(city3,initCity3);
        checkedCities.put("city3",newCity3);
    }

}
