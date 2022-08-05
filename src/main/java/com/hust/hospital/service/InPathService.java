package com.hust.hospital.service;

import com.hust.hospital.entity.InPath;

import java.util.List;

/**
 * @author EdwardXu
 */
public interface InPathService {
    /**
     * 获取所有病人的列表
     * @return 所有病人的列表
     */
    List<InPath> getInPaths();
    /**
     * 根据id查询病人
     * @param id
     * @return
     */
    InPath getInPathById(String id);

    /**
     * 添加一个病人到数据库
     * @param patient
     */
    void addInPath(InPath patient);

    /**
     * 修改一个病人的数据
     * @param patient
     * @return
     */

    void updateInPath(InPath patient);

    /**
     * 删除一个病人的数据
     * @param id
     * @return
     */

    void deleteInPath(String id);

    /**
     * 根据username返回一个InPath
     * @param username
     * @return
     */
    InPath getInPathByName(String username);
}
