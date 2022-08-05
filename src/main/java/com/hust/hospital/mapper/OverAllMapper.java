package com.hust.hospital.mapper;

import com.hust.hospital.entity.OverAll;


/**
 * 路径总览数据库操作对象
 * @author EdwardXu
 */
public interface OverAllMapper {
    /**
     * 根据病人id返回总览
     * @param id
     * @return
     */
    OverAll getOverAllById(String id);

    /**
     * 添加一个病人的总览到数据库
     * @param overAll
     */
    void addOverAll(OverAll overAll);

    /**
     * 修改一个病人的总览
     * @param overAll
     * @return
     */

    void updateOverAll(OverAll overAll);

    /**
     * 删除一个病人的总览
     * @param id
     * @return
     */

    void deleteOverAll(String id);
}
