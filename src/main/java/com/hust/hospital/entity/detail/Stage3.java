package com.hust.hospital.entity.detail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author EdwardXu
 * 第三阶段的展示
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stage3 {

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
        return "{\"city0\":[\"上级医师查房\",\"完成入院检查\",\"继续对症支持治疗\",\"完成必要的相关科室会诊\",\"完成上级医师查房记录等病历书写\",\"向患者及家属交待病情及其注意事项\"],\"city1\":[\"患者既往基础用药\",\"其他医嘱\"],\"city2\":[\"骨髓穿刺和骨髓活检（必要时）\",\"骨髓形态学、病理、免疫组化（必要时）\",\"外周血免疫表型\",\"外周血细胞(CpG刺激)/分子遗传学\",\"分子生物学检测TP53基因突变及IGHV突变状态\",\"自身免疫系统疾病筛查\",\"输血（有指征时）\",\"其他医嘱\"],\"city3\":[\"观察患者病情变化\"]}";
    }
    public static String getInitialCheckedCities() {
        return "{\"city0\":[\"\",\"\"],\"city1\":[\"\",\"\"],\"city2\":[\"\",\"\"],\"city3\":[\"\",\"\"]}";
    }
    public static String getInitialDetailCities() {
        return "{\"city0\":{},\"city1\":{\"input1\":\"\",\"input0\":\"\"},\"city2\":{\"input4\":[],\"input3\":\"\",\"input2\":[],\"input1\":[],\"input0\":[]},\"city3\":{}}";
    }



}
