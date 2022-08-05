package com.hust.hospital.mapper;


import com.hust.hospital.entity.detail.Stage2;

public interface Stage2Mapper {
    /**
     * 根据id查询病人的阶段2
     * @param id
     * @return
     */
    Stage2 getStage2ById(String id);

    /**
     * 加入第一阶段的数据
     * @param s
     */
    void addStage2(Stage2 s);

    /**
     * 更新数据
     * @param s
     */
    void updateStage2(Stage2 s);
}
