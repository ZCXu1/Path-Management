package com.hust.hospital.service.impl;

import com.hust.hospital.entity.OverAll;
import com.hust.hospital.mapper.OverAllMapper;
import com.hust.hospital.service.OverAllService;
import com.hust.hospital.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

/**
 * @author EdwardXu
 */
@Service
public class OverAllServiceImpl implements OverAllService {
    @Override
    public OverAll getOverAllById(String id) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            OverAllMapper mapper = sqlSession.getMapper(OverAllMapper.class);
            return mapper.getOverAllById(id);
        }
    }

    @Override
    public void addOverAll(OverAll overAll) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            OverAllMapper mapper = sqlSession.getMapper(OverAllMapper.class);
            mapper.addOverAll(overAll);
            //提交事务
            sqlSession.commit();
        }
    }

    @Override
    public void updateOverAll(OverAll overAll) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            OverAllMapper mapper = sqlSession.getMapper(OverAllMapper.class);
            mapper.updateOverAll(overAll);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteOverAll(String id) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            OverAllMapper mapper = sqlSession.getMapper(OverAllMapper.class);
            mapper.deleteOverAll(id);
            sqlSession.commit();
        }
    }
}
