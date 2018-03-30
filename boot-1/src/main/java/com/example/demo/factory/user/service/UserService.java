package com.example.demo.factory.user.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.User;
import com.github.pagehelper.Page;

public interface UserService {

    /**
     * 查询用户信息
     */
	Page<Map<String, Object>>  queryUsers();    
    
    /**
     * 获取用户的职位权限
     */
    Integer userPermission(Integer id);
    
    User findByNameAndPassword(String name,String password); 
}
