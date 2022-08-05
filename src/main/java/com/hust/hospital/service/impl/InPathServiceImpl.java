package com.hust.hospital.service.impl;

import com.hust.hospital.entity.InPath;
import com.hust.hospital.mapper.InPathMapper;
import com.hust.hospital.service.InPathService;
import com.hust.hospital.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author EdwardXu
 */
@Service
public class InPathServiceImpl implements InPathService {
    @Override
    public List<InPath> getInPaths() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            InPathMapper mapper = sqlSession.getMapper(InPathMapper.class);
            return mapper.getInPaths();
        }
    }

    @Override
    public InPath getInPathById(String id) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            InPathMapper mapper = sqlSession.getMapper(InPathMapper.class);
            return mapper.getInPathById(id);
        }
    }

    @Override
    public void addInPath(InPath patient) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            InPathMapper mapper = sqlSession.getMapper(InPathMapper.class);
            mapper.addInPath(patient);
            //提交事务
            sqlSession.commit();
        }
    }

    @Override
    public void updateInPath(InPath patient) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            InPathMapper mapper = sqlSession.getMapper(InPathMapper.class);
            mapper.updateInPath(patient);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteInPath(String id) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            InPathMapper mapper = sqlSession.getMapper(InPathMapper.class);
            mapper.deleteInPath(id);
            sqlSession.commit();
        }
    }

    @Override
    public InPath getInPathByName(String username) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            InPathMapper mapper = sqlSession.getMapper(InPathMapper.class);
            return mapper.getInPathByName(username);
        }
    }
}
