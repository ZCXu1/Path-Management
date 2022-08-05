package com.hust.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author EdwardXu
 * @description 从前端接收登陆的表单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
