package com.city.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory{
    //成员变量
	private Object target;
	//注入target目标对象
	public JdkProxyFactory(Object target) {
		this.target = target;
	}
	
	public Object getProxyObject(){
		//参数1：目标对象的类加载器
		//参数2：目标对象实现的接口
		//参数3：回调方法对象
		/**方案一：在内部实现new InvocationHandler()，指定匿名类*/
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler(){

			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				//如果是保存的方法，执行记录日志操作
				if(method.getName().equals("save")){
					writeLog();
				}
				//目标对象原来的方法执行
				Object object = method.invoke(target, args);//调用目标对象的某个方法，并且返回目标对象方法的返回值
				return object;
			}
			
		});
	}
	
	//记录日志
	private static void writeLog(){
		System.out.println("增强代码：写日志了。。。");
	}

}