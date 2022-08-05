package com.hust.hospital.mapper;

import com.hust.hospital.entity.detail.Stage3;

public interface Stage3Mapper {
    /**
     * 根据id查询病人的阶段3
     * @param id
     * @return
     */
    Stage3 getStage3ById(String id);

    /**
     * 加入第一阶段的数据
     * @param s
     */
    void addStage3(Stage3 s);

    /**
     * 更新数据
     * @param s
     */
    void updateStage3(Stage3 s);
}
