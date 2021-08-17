package com.city.redis;

import com.alibaba.fastjson.JSON;
import com.citycloud.dcm.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author weiyl
 * @date 2021/4/20 16:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes =  Application.class)
@Slf4j
public class TestHash {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSetValue(){
        redisTemplate.boundHashOps("namehash").put("a", "唐僧");
        redisTemplate.boundHashOps("namehash").put("b", "悟空");
        redisTemplate.boundHashOps("namehash").put("c", "八戒");
        redisTemplate.boundHashOps("namehash").put("d", "沙僧");
        Set s = redisTemplate.boundHashOps("namehash").keys();
        Object object = redisTemplate.boundHashOps("namehash").get("b");
        System.out.println(object);
        System.out.println(s);
    }


    @Test
    public void testGetKeys(){
        Set s = redisTemplate.boundHashOps("namehash").keys();
        System.out.println(s);

//        redisTemplate.boundValueOps("key2").set("nihao");
//        redisTemplate.opsForValue().set("key3", "hello");

   //     BoundValueOperations saa = redisTemplate.boundValueOps("key2");
//        saa.append("bbb");

//        int newLen = redisTemplate.opsForValue().append("key2","_app");
//        System.out.println(newLen);

        System.out.println(redisTemplate.opsForValue().get("key2"));
        System.out.println(redisTemplate.boundValueOps("key3").get());


    }

    @Test
    public void append(){
        redisTemplate.opsForValue().set("test2", "aaaaaa");
        redisTemplate.opsForValue().append("test2","1111");
        String stringValueAppend = redisTemplate.opsForValue().get("test2")+"";
        System.out.println("通过append(K key, String value)方法修改后的字符串:"+stringValueAppend);


       // redisTemplate.opsForValue().append("stringValue","aaa");
       // String stringValueAppend = redisTemplate.opsForValue().get("key2")+"";
      //  System.out.println("通过append(K key, String value)方法修改后的字符串:"+stringValueAppend);
    }



    @Test
    public void testGetValues(){
        List values = redisTemplate.boundHashOps("namehash").values();
        System.out.println(values);
    }

    @Test
    public void testGetValueByKey(){
        Object object = redisTemplate.boundHashOps("namehash").get("b");
        System.out.println(object);
    }


    @Test
    public void testRemoveValueByKey(){
        redisTemplate.boundHashOps("namehash").delete("c");
    }
}
