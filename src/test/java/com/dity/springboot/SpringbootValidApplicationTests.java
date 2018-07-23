package com.dity.springboot;

import com.dity.springboot.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootValidApplicationTests {

	@Autowired
	Validator validator;

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

}
