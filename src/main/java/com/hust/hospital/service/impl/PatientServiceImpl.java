package com.hust.hospital.service.impl;

import com.hust.hospital.entity.Patient;
import com.hust.hospital.mapper.PatientMapper;
import com.hust.hospital.service.PatientService;
import com.hust.hospital.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EdwardXu
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Override
    public List<Patient> getPatients() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            PatientMapper mapper = sqlSession.getMapper(PatientMapper.class);
            return mapper.getPatients();
        }
    }

    @Override
    public Patient getPatientById(String id) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            PatientMapper mapper = sqlSession.getMapper(PatientMapper.class);
            return mapper.getPatientById(id);
        }
    }

    @Override
    public void addPatient(Patient patient) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            PatientMapper mapper = sqlSession.getMapper(PatientMapper.class);
            mapper.addPatient(patient);
            //提交事务
            sqlSession.commit();
        }
    }

    @Override
    public void updatePatient(Patient patient) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            PatientMapper mapper = sqlSession.getMapper(PatientMapper.class);
            mapper.updatePatient(patient);
            sqlSession.commit();
        }
    }

    @Override
    public void deletePatient(String id) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            PatientMapper mapper = sqlSession.getMapper(PatientMapper.class);
            mapper.deletePatient(id);
            sqlSession.commit();
        }
    }

    @Override
    public Patient getPatientByName(String username) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            PatientMapper mapper = sqlSession.getMapper(PatientMapper.class);
            return mapper.getPatientByName(username);
        }
    }

    @Override
    public List<Integer> getBeds() {
        List<Integer> ans = new ArrayList<>();
        List<Patient> patients = getPatients();
        for(Patient p :patients){
            ans.add(p.getBed());
        }
        return ans;
    }
}
