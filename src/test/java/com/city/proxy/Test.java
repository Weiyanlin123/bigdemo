package com.city.proxy;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author weiyl
 * @date 2021/9/4 19:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {
    //目标：使用动态代理，对原来的方法进行功能增强,而无需更改原来的代码。
    //JDK动态代理：基于接口的（对象的类型，必须实现接口！）
    @org.junit.Test
    public void testJdkProxy(){
        //target（目标对象）
        ICustomerService target = new CustomerServiceImpl();
        //实例化注入目标对象
        JdkProxyFactory jdkProxyFactory = new JdkProxyFactory(target);
        //获取Proxy Object代理对象:基于目标对象类型的接口的类型的子类型的对象
        ICustomerService proxy = (ICustomerService)jdkProxyFactory.getProxyObject();
        //调用目标对象的方法
        proxy.save();
        System.out.println("————————————————————————————————————————");
        proxy.find();
    }//cglib动态代理：可以基于类（无需实现接口）生成代理对象
    @org.junit.Test
    public void testCglibProxy(){
        //target目标：
        ProductService target = new ProductService();
        //weave织入，生成proxy代理对象
        //代理工厂对象，注入目标
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(target);
        //获取proxy:思考：对象的类型
        //代理对象，其实是目标对象类型的子类型
        ProductService proxy=(ProductService) cglibProxyFactory.getProxyObject();
        //调用代理对象的方法
        proxy.save();
        System.out.println("————————————————————————————————————————");
        proxy.find();

    }


}
