package com.example.demo.page.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.example.demo.config.RedisOperator;
import com.example.demo.entity.User;

/**
 * redis操作接口
 * 
 * @author mhs
 *
 */
@Controller
@RequestMapping("redis")
public class RedisController {
	@Autowired
	private RedisOperator stringRedisTemplate;
    //普通用法 key -value
	@RequestMapping(value = "/redis/{key}/{value}", method = RequestMethod.GET)
	@ResponseBody
	public String redisTest(@PathVariable String key, @PathVariable String value) {
		String redisValue = stringRedisTemplate.get(key);
		if (StringUtils.isEmpty(redisValue)) {
			stringRedisTemplate.set(key, value);
			return "操作成功！";
		}

		if (!redisValue.equals(value)) {
			stringRedisTemplate.set(key, value);
			return "操作成功！";
		}

		return String.format("redis中已存在[key=%s,value=%s]的数据！", key, value);
	}
	//存对象
	@RequestMapping("/redis/user")
	@ResponseBody
	public String redisTestBean(String key, User user) {
	  User user_old = JSON.parseObject(stringRedisTemplate.get(key),User.class);
		if (user_old==null) {
			stringRedisTemplate.set(key,  JSON.toJSONString(user));
			return "操作成功！<br>"+JSON.toJSONString(user);
		}

		if (!JSON.toJSONString(user).equals(JSON.toJSONString(user_old))) {
			stringRedisTemplate.set(key,  JSON.toJSONString(user));
			return "操作成功！<br>"+JSON.toJSONString(user);
		}
		return "redis已存在key<br>"+JSON.toJSONString(user_old);
		
	}
}
