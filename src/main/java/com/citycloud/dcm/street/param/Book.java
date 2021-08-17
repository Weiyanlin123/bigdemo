package com.citycloud.dcm.street.param;

/**
 * @author weiyl
 * @date 2021/4/13 10:18
 */
public class Book {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    String name;
    Integer id;
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Book(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}

