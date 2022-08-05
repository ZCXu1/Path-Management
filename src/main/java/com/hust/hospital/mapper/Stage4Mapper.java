package com.hust.hospital.mapper;

import com.hust.hospital.entity.detail.Stage4;

public interface Stage4Mapper {
    /**
     * 根据id查询病人的阶段4
     * @param id
     * @return
     */
    Stage4 getStage4ById(String id);

    /**
     * 加入第一阶段的数据
     * @param s
     */
    void addStage4(Stage4 s);

    /**
     * 更新数据
     * @param s
     */
    void updateStage4(Stage4 s);
}
