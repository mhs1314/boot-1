package com.example.demo.factory.user.service;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 根据用户名和密码查询用户信息
     */
	 List<Map<String, Object>>  queryUserByNamePWD(Map<String, Object> paramMap);    
    
    /**
     * 获取用户的职位权限
     */
    Integer userPermission(Integer id);
}
