package com.hust.hospital.entity.detail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author EdwardXu
 * 第四阶段的展示
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stage4 {

    private String patientId;

    /**
     * json格式的数据
     * 一个阶段的所有部分中被选中的数据
     */
    private String checkedCities;
    /**
     * json格式数据
     * 一个阶段的所有部分的所有备选数据
     */
    private String cities;
    /**
     * json格式数据
     * 一个阶段的所有部分的选中数据的要输入的额外信息
     */
    private String detailCities;

    private LocalDate beginDate;

    private LocalTime beginTime;

    private LocalDate endDate;

    private LocalTime endTime;


    public static String getInitialCities() {
        return "{\"city0\":[\"上级医师查房，进行评估，确定有无并发症情况，明确是否出院\",\"完成出院记录、病案首页、出院证明书等\",\"向患者交代出院后的注意事项，如：返院复诊的时间、地点，发生紧急情况时的处理等\"],\"city1\":[\"出院带药\",\"定期门诊随访\",\"监测血常规\"],\"city2\":[\"其他医嘱\"],\"city3\":[\"指导患者办理出院手续\"]}";
    }
    public static String getInitialCheckedCities() {
        return "{\"city0\":[\"\"],\"city1\":[\"\"],\"city2\":[\"\"],\"city3\":[\"\"]}";
    }
    public static String getInitialDetailCities() {
        return "{\"city0\":{},\"city1\":{\"input1\":\"\",\"input0\":\"\"},\"city2\":{\"input4\":[],\"input3\":\"\",\"input2\":[],\"input1\":[],\"input0\":[]},\"city3\":{}}";
    }

}
