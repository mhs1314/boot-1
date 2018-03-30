package com.example.demo.data.csdnblog.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.CsdnBlog;

//rest数据资源
@RepositoryRestResource(collectionResourceRel = "CsdnBlog", path = "CsdnJpa")
public interface CsdnBlogJpaDao extends PagingAndSortingRepository<CsdnBlog,Long>{
}
