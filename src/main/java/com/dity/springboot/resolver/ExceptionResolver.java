package com.dity.springboot.resolver;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author:yuhang
 * @Date:2018/7/23
 */
@ControllerAdvice
public class ExceptionResolver  {

    /**
     * 用于对实体的校验 普通提交的方式
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Map<String,Object> bind(BindException e){
        Map<String,Object> map=new HashMap<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        StringBuffer sb=new StringBuffer();
        for (FieldError fieldError : fieldErrors) {
            sb.append(fieldError.getDefaultMessage()).append("\n");
        }
        map.put("code","-1");
        map.put("msg",sb.toString());
        return map;
    }

    /**
     * 对方法参数的校验 获取错误的校验信息
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Map<String,Object> bind(ConstraintViolationException e){
        Map<String,Object> map=new HashMap<>();
        StringBuffer sb=new StringBuffer();
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            sb.append(constraintViolation.getMessage());
        }
        map.put("code","-1");
        map.put("msg",sb.toString());
        return map;
    }

    /**
     * 针对于 @RequestBody注解的实体可以获得相应参数
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String,Object> bind(MethodArgumentNotValidException e){
        Map<String,Object> map=new HashMap<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        StringBuffer sb=new StringBuffer();
        for (FieldError fieldError : fieldErrors) {
            sb.append(fieldError.getDefaultMessage());
        }
        map.put("code","-1");
        map.put("msg",sb.toString());
        return map;
    }
}
