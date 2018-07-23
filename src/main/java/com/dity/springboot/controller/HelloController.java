package com.dity.springboot.controller;

import com.dity.springboot.entity.Emp;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author:yuhang
 * @Date:2018/7/23
 * 参数校验
 * javabean里加了jsr或者hibernate的校验规则
 * 方法形参上 加了@Valid注解 即可在参数传递不规范时抛出异常
 *
 * 手动的获取方法形参的校验
 * Set<ConstraintViolation<AppInfoDTO>> set = validator.validate(appInfoDto, clazz);
 */
@Controller
@Validated//支持方法级别的校验
public class HelloController {

    /**
     * 对json数据的校验 抛出的异常不同
     */
    @RequestMapping("hello")
    @ResponseBody
    public Emp hello(@Valid @RequestBody Emp emp){
        return emp;
    }

    /**
     * 方法上的校验
     * @param user
     * @return
     */
    @RequestMapping("hi")
    @ResponseBody
    public String hello(@NotBlank(message = "user不能为空") String user){
        return user;
    }

    /**
     * 对于实体的校验
     * @Valid和@Validated都可以做校验
     * 但是后者可以指定分组 推荐使用
     * @param emp
     * @return
     */
    @RequestMapping("say")
    @ResponseBody
    public Emp say(@Validated(Emp.Adult.class) Emp emp){
        return emp;
    }
}
