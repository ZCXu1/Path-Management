package com.hust.hospital.service.impl;

import com.hust.hospital.entity.Variation;

import com.hust.hospital.mapper.VariationMapper;
import com.hust.hospital.service.VariationService;
import com.hust.hospital.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class VariationServiceImpl implements VariationService {
    @Override
    public Variation getVariationById(String id) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            VariationMapper mapper = sqlSession.getMapper(VariationMapper.class);
            return mapper.getVariationById(id);
        }
    }

    @Override
    public void addVariation(Variation v) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            VariationMapper mapper = sqlSession.getMapper(VariationMapper.class);
            mapper.addVariation(v);
            sqlSession.commit();
        }
    }

    @Override
    public void updateVariation(Variation v) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            VariationMapper mapper = sqlSession.getMapper(VariationMapper.class);
            mapper.updateVariation(v);
            sqlSession.commit();
        }
    }
}
