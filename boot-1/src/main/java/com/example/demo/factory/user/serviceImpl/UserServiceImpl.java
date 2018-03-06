package com.example.demo.factory.user.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.user.dao.UserDao;
import com.example.demo.factory.user.service.UserService;



@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDao userMapper;

    /**
     * 根据用户名和密码查询用户信息
     * @param username, password
     * @return User
     */
    @Override
    public Map<String,Object> queryUserByNamePWD(String username, String password) {
        return userMapper.queryUserByNamePWD(username, password);
    }

    /**
     * 获取用户的权限
     * @param id 职位的ID
     * @return
     */
    @Override
    public Integer userPermission(Integer id) {
        return userMapper.userPermission(id);
    }

}
