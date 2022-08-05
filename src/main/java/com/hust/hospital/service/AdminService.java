package com.hust.hospital.service;

import com.hust.hospital.entity.Admin;

/**
 * @author EdwardXu
 * @description 管理员的service层
 */
public interface AdminService {
    /**
     * 根据用户名获得密码
     * @param username
     * @return
     */
    Admin getAdminByUsername(String username);
}
