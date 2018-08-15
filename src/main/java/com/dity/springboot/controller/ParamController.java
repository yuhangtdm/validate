package com.dity.springboot.controller;

import com.dity.springboot.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author:yuhang
 * @Date:2018/8/15
 */
@Controller
public class ParamController {


    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "param1")
    @ResponseBody
    public String param1(String param){
        System.out.println(param);
        return "success"+param;
    }

    @RequestMapping(value = "param2")
    @ResponseBody
    public List<String> param2(@RequestParam String[] param){
        return Arrays.asList(param);
    }

    @RequestMapping(value = "param3")
    @ResponseBody
    public Emp param3( Emp emp){
        return emp;
    }

    @RequestMapping(value = "param4")
    @ResponseBody
    public List<Emp> param4(@RequestBody List<Emp> emps){
        return emps;
    }

}
