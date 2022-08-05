package com.hust.hospital.mapper;

import com.hust.hospital.entity.detail.Stage1;

/**
 * @author EdwardXu
 */
public interface Stage1Mapper {
    /**
     * 根据id查询病人的阶段1
     * @param id
     * @return
     */
    Stage1 getStage1ById(String id);

    /**
     * 加入第一阶段的数据
     * @param s
     */
    void addStage1(Stage1 s);

    /**
     * 更新数据
     * @param s
     */
    void updateStage1(Stage1 s);
}
