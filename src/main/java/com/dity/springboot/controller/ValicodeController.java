package com.dity.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author:yuhang
 * @Date:2018/8/15
 */
@Controller
public class ValicodeController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping("vali")
    public String toValicode(){
        return "valicode";
    }

    @RequestMapping("sendCode")
    @ResponseBody
    public String sendCode(String phoneNo){
        String s = stringRedisTemplate.opsForValue().get("phone_no_" + phoneNo + "_count");
        if(s==null){
            stringRedisTemplate.opsForValue().set("phone_no_" + phoneNo + "_count","1",24*60*60,TimeUnit.SECONDS);
        }else if(Integer.parseInt(s)==4){
            return "error";
        }else{
            stringRedisTemplate.opsForValue().increment("phone_no_" + phoneNo + "_count",1);
        }
        String random=radom();
        System.out.println("您收到的验证码是:"+random);
        stringRedisTemplate.opsForValue().set("phone_no_"+phoneNo+"_vali",random,60, TimeUnit.SECONDS);



        return "success";
    }

    @RequestMapping("confirm")
    @ResponseBody
    public String confirm(@RequestParam String phoneNo,@RequestParam String code){


        String s = stringRedisTemplate.opsForValue().get("phone_no_" + phoneNo + "_vali");
        if(code.equals(s)){
            return "success";
        }else {
            return "error";
        }

    }

    private String radom(){
        StringBuffer sb=new StringBuffer();
        for(int i=1;i<=6;i++){
            int random=new Random().nextInt(10);
            sb.append(random);
        }
        return sb.toString();
    }
}
