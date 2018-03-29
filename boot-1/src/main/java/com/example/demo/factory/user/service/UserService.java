package com.example.demo.factory.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;

public interface UserService {

    /**
     * 根据用户名和密码查询用户信息
     */
	 List<Map<String, Object>>  queryUserByNamePWD(Map<String, Object> paramMap);    
    
    /**
     * 获取用户的职位权限
     */
    Integer userPermission(Integer id);
    
    User findByNameAndPassword(String name,String password); 
}
