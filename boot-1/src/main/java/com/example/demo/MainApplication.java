package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//mybaits扫描dao类路径
@MapperScan("com.example.demo.data.*.dao")
@SpringBootApplication
public class MainApplication  {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
}
