package com.citycloud.dcm.street.config.test;

import com.citycloud.dcm.street.param.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * @author weiyl
 * @date 2021/4/12 17:29
 */
@Configuration
@ComponentScan("com.citycloud.dcm.street.param")
public class BookConifg {

    @Bean
    public Book book(){
        Book book = new Book("nohao",1);
        return book;
    }


}
