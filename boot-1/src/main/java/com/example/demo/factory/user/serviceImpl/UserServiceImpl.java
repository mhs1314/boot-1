package com.example.demo.factory.user.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.user.dao.UserDao;
import com.example.demo.data.user.dao.UserJpaDao;
import com.example.demo.entity.User;
import com.example.demo.factory.user.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;



@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDao userMapper;
    @Autowired
    private UserJpaDao userjpa;

    /**
     * 查询用户信息
     * @param username, password
     * @return User
     */
    @Override
    public  Page<Map<String, Object>> queryUsers() {
    	/*  
         * 第一个参数是第几页；第二个参数是每页显示条数。  
         */  
        PageHelper.startPage(1,2); 
        PageHelper.orderBy("id");
        Page<Map<String, Object>> page =(Page<Map<String, Object>>) userMapper.queryUsers();
    	return page;
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

	@Override
	public User findByNameAndPassword(String name,String password) {
		// TODO Auto-generated method stub
		return userjpa.findBynameAndPassword(name,password);
	}

}
