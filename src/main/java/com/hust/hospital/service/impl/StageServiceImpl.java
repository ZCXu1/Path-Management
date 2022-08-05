package com.hust.hospital.service.impl;

import com.hust.hospital.entity.detail.Stage1;
import com.hust.hospital.entity.detail.Stage2;
import com.hust.hospital.entity.detail.Stage3;
import com.hust.hospital.entity.detail.Stage4;
import com.hust.hospital.mapper.Stage1Mapper;
import com.hust.hospital.mapper.Stage2Mapper;
import com.hust.hospital.mapper.Stage3Mapper;
import com.hust.hospital.mapper.Stage4Mapper;
import com.hust.hospital.service.StageService;
import com.hust.hospital.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

/**
 * @author EdwardXu
 */
@Service
public class StageServiceImpl implements StageService {
    @Override
    public Stage1 getStage1ById(String id) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            Stage1Mapper mapper = sqlSession.getMapper(Stage1Mapper.class);
            return mapper.getStage1ById(id);
        }
    }
    @Override
    public void addStage1(Stage1 s) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            Stage1Mapper mapper = sqlSession.getMapper(Stage1Mapper.class);
            mapper.addStage1(s);
            //提交事务
            sqlSession.commit();
        }
    }
    @Override
    public void updateStage1(Stage1 s) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            Stage1Mapper mapper = sqlSession.getMapper(Stage1Mapper.class);
            mapper.updateStage1(s);
            sqlSession.commit();
        }
    }

    @Override
    public Stage2 getStage2ById(String id) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            Stage2Mapper mapper = sqlSession.getMapper(Stage2Mapper.class);
            return mapper.getStage2ById(id);
        }
    }

    @Override
    public void addStage2(Stage2 s) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            Stage2Mapper mapper = sqlSession.getMapper(Stage2Mapper.class);
            mapper.addStage2(s);
            //提交事务
            sqlSession.commit();
        }
    }

    @Override
    public void updateStage2(Stage2 s) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            Stage2Mapper mapper = sqlSession.getMapper(Stage2Mapper.class);
            mapper.updateStage2(s);
            sqlSession.commit();
        }
    }

    @Override
    public Stage3 getStage3ById(String id) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            Stage3Mapper mapper = sqlSession.getMapper(Stage3Mapper.class);
            return mapper.getStage3ById(id);
        }
    }

    @Override
    public void addStage3(Stage3 s) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            Stage3Mapper mapper = sqlSession.getMapper(Stage3Mapper.class);
            mapper.addStage3(s);
            //提交事务
            sqlSession.commit();
        }
    }

    @Override
    public void updateStage3(Stage3 s) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            Stage3Mapper mapper = sqlSession.getMapper(Stage3Mapper.class);
            mapper.updateStage3(s);
            sqlSession.commit();
        }
    }

    @Override
    public Stage4 getStage4ById(String id) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            Stage4Mapper mapper = sqlSession.getMapper(Stage4Mapper.class);
            return mapper.getStage4ById(id);
        }
    }

    @Override
    public void addStage4(Stage4 s) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            Stage4Mapper mapper = sqlSession.getMapper(Stage4Mapper.class);
            mapper.addStage4(s);
            //提交事务
            sqlSession.commit();
        }
    }

    @Override
    public void updateStage4(Stage4 s) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            Stage4Mapper mapper = sqlSession.getMapper(Stage4Mapper.class);
            mapper.updateStage4(s);
            sqlSession.commit();
        }
    }
}
