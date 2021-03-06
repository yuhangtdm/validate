package com.dity.springboot;

import com.dity.springboot.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootValidApplicationTests {

	@Autowired
	Validator validator;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {
		Emp emp=new Emp();
		emp.setSex("ss");
		emp.setName("nihao");
		System.out.println(emp);
		Set<ConstraintViolation<Emp>> validate = validator.validate(emp);
		for (ConstraintViolation<Emp> empConstraintViolation : validate) {
			System.out.println(empConstraintViolation.getMessage());
		}
	}

	@Test
	public void testString(){
		String str="s17209897656";
		System.out.println(str.substring(1,str.length()));
	}

	@Test
	public void testRedis(){
//		redisTemplate.opsForValue().set("sec_1001","10");
		SetOperations<String,Object> setOperations = redisTemplate.opsForSet();


		setOperations.add("sec_user", 1234);
	}

}
