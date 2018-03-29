package com.example.demo.data.user.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.User;

//rest数据资源
@RepositoryRestResource(collectionResourceRel = "user", path = "UserJpa")
public interface UserJpaDao extends PagingAndSortingRepository<User,Long>{
	List<User> findByname(@Param("username")String username);   
	User findBynameAndPassword(@Param("username")String username,@Param("password")String password);   
}
