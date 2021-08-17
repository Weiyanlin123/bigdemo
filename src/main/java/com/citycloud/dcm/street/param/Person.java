package com.citycloud.dcm.street.param;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author weiyl
 * @date 2020/9/7 15:12
 */
@Data
public class Person {

    private Integer id;

    private String name;

    private Integer age;

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
