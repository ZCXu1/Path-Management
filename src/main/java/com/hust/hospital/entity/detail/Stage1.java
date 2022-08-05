package com.hust.hospital.entity.detail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author EdwardXu
 * 第一阶段的展示
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stage1 {

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

    public static String getInitialCities(){
        return "{\"city0\":[\"询问病史及体格检查\",\"完成病历书写\",\"开实验室检查单\",\"对症支持治疗\",\"病情告知，必要时向患者家属告病重或病危通知，并签署病重或病危通知书\",\"患者家属签署各种必要的知情同意书\"],\"city1\":[\"血液病护理常规\",\"二级护理\",\"饮食\",\"视病情通知病重或病危\",\"其他医嘱\"],\"city2\":[\"常规检查\",\"功能性检查\",\"乙肝二对半\",\"射线检查\",\"输血（有指征时）等支持对症治疗\",\"其他医嘱\",\"细化检查\"],\"city3\":[\"介绍病房环境、设施和设备\",\"入院护理评估\",\"宣教\"]}";
    }
    public static String getInitialCheckedCities(){
        return "{\"city0\":[\"\",\"\",\"\",\"\"],\"city1\":[\"\",\"\"],\"city2\":[\"\",\"\",\"\"],\"city3\":[\"\",\"\"]}";
    }
    public static String getInitialDetailCities(){
        return "{\"city0\":{},\"city1\":{\"input1\":\"\",\"input0\":\"\"},\"city2\":{\"input4\":[\"\",\"\"],\"input3\":\"\",\"input2\":[],\"input1\":[],\"input0\":[]},\"city3\":{}}";
    }
}
