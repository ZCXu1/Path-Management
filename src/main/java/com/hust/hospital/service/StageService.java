package com.hust.hospital.service;

import com.hust.hospital.entity.detail.Stage1;
import com.hust.hospital.entity.detail.Stage2;
import com.hust.hospital.entity.detail.Stage3;
import com.hust.hospital.entity.detail.Stage4;

public interface StageService {
    /**
     * 根据id查询病人的阶段1
     * @param id
     * @return
     */
    Stage1 getStage1ById(String id);

    void addStage1(Stage1 s);

    void updateStage1(Stage1 s);

    Stage2 getStage2ById(String id);

    void addStage2(Stage2 s);

    void updateStage2(Stage2 s);

    Stage3 getStage3ById(String id);

    void addStage3 (Stage3  s);

    void updateStage3 (Stage3 s);

    Stage4 getStage4ById(String id);

    void addStage4(Stage4 s);

    void updateStage4(Stage4 s);

}
