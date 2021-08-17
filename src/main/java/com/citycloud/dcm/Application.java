package com.citycloud.dcm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.citycloud.dcm.street.mapper")
public class Application {

    public static void main(String[] args) {
//        Integer integer = new Integer(0);
//        Double aDouble = new Double(0);
//        Double aDouble1 = new Double(0);
//        Integer integer1 = new Integer(0);
//
//        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
//        objectObjectConcurrentHashMap.put("","");
//
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.get("");
//        objectObjectHashMap.put("","");
        SpringApplication.run(Application.class, args);

    }

}
