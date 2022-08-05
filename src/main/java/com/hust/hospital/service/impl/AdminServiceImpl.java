package com.hust.hospital.service.impl;

import com.hust.hospital.entity.Admin;
import com.hust.hospital.mapper.AdminMapper;

import com.hust.hospital.service.AdminService;
import com.hust.hospital.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

/**
 * @author EdwardXu
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public Admin getAdminByUsername(String username) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
            return mapper.getAdminByUsername(username);
        }
    }
}
