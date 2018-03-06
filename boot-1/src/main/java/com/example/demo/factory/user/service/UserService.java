package com.example.demo.factory.user.service;

import java.util.Map;

public interface UserService {

    /**
     * 根据用户名和密码查询用户信息
     */
	Map<String,Object>  queryUserByNamePWD(String username, String password);    
    
    /**
     * 获取用户的职位权限
     */
    Integer userPermission(Integer id);
}
