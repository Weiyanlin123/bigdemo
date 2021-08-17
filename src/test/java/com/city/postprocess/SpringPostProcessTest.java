package com.city.postprocess;

import com.citycloud.dcm.street.config.test.BookConifg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author weiyl
 * @date 2021/4/12 16:57
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class SpringPostProcessTest {

    @Test
    public void getProcess(){

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BookConifg.class);
        Object book = annotationConfigApplicationContext.getBean("book");
        System.out.println("=========================="+book);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        System.out.println(formatter.format(time));


    }
}
