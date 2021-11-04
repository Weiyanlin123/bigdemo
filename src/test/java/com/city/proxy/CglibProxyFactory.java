package com.city.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory implements MethodInterceptor {
    //声明一个代理对象引用
	private Object target;
	//注入代理对象
	public CglibProxyFactory(Object target) {
		this.target = target;
	}
	
	//获取代理对象
	public Object getProxyObject(){
		//1.代理对象生成器(工厂思想)
		Enhancer enhancer = new Enhancer();
		//2.在增强器上设置两个属性
		//设置要生成代理对象的目标对象：生成的目标对象类型的子类型
		enhancer.setSuperclass(target.getClass());
		//设置回调方法
		enhancer.setCallback(this);
//		Callback
		//3.创建获取对象
		return enhancer.create();
	}

	
	//回调方法（代理对象的方法）
	//参数1：代理对象
	//参数2：目标对象的方法对象
	//参数3：目标对象的方法的参数的值
	//参数4：代理对象的方法对象
	public Object intercept(Object proxy, Method method, Object[] args,
							MethodProxy methodProxy) throws Throwable {
		//如果是保存的方法，执行记录日志操作
		if(method.getName().equals("save")){
			writeLog();
		}
		//目标对象原来的方法执行
		Object object = method.invoke(target, args);//调用目标对象的某个方法，并且返回目标对象方法的执行结果
		return object;
	}
	
	//写日志的增强功能
	//Advice通知、增强
	//记录日志
	private static void writeLog(){
		System.out.println("增强代码：写日志了。。。");
	}
	
}