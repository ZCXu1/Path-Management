package com.hust.hospital.service;

import com.hust.hospital.entity.Patient;

import java.util.List;


/**
 * @author EdwardXu
 * @description 病人的Service层
 */
public interface PatientService {
    /**
     * 获取所有病人的列表
     * @return 所有病人的列表
     */
    List<Patient> getPatients();
    /**
     * 根据id查询病人
     * @param id
     * @return
     */
    Patient getPatientById(String id);

    /**
     * 添加一个病人到数据库
     * @param patient
     */
    void addPatient(Patient patient);

    /**
     * 修改一个病人的数据
     * @param patient
     * @return
     */

    void updatePatient(Patient patient);

    /**
     * 删除一个病人的数据
     * @param id
     * @return
     */

    void deletePatient(String id);

    /**
     * 根据username返回一个Patient
     * @param username
     * @return
     */
    Patient getPatientByName(String username);

    List<Integer> getBeds();
}
