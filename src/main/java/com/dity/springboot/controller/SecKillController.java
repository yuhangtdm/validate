package com.dity.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author:yuhang
 * @Date:2018/8/16
 * 秒杀控制器
 * 商品规定多少件    秒杀 很多用户来抢 目的是把这些商品抢光
 * 商品的库存减少 抢到的用户列表增加
 * 模拟客户端发送请求
 *
 */
@Controller
public class SecKillController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("secKill")
    public String secKill(){
       return "secKill";
    }

   @RequestMapping("doSecKill")
   @ResponseBody
   public synchronized String doSecKill(@RequestParam String pid){
       String stock= stringRedisTemplate.opsForValue().get("sec_"+pid);
           if(Integer.parseInt(stock)<=0){
               System.out.println("已抢光");
               return "已抢光";
           }else {
//           redisTemplate.watch("sec_user");
//           redisTemplate.multi();
               String userId=generateUserId();
               Boolean sec_user = redisTemplate.opsForSet().isMember("sec_user", userId);
               if(sec_user){
                   System.out.println("已抢到手");
                   return "已抢到手";
               }
               redisTemplate.opsForSet().add("sec_user", userId);
               stringRedisTemplate.opsForValue().increment("sec_"+pid,-1);

               System.out.println("抢购成功");
           }

       return "抢购成功";
   }

    /**
     * 模拟客户端的id
     * @return
     */
    public String generateUserId(){
        int i = new Random().nextInt(5000);
       return i+"";
    }
}
