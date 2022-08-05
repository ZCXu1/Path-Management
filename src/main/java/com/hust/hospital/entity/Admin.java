package com.hust.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author EdwardXu
 * @description 管理员
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
