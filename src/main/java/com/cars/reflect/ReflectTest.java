package com.cars.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Description 框架类(框架:半成品软件)
 * @Author Wy005
 * @Date 2020/7/27 15:12
 * @Version 1.0
 **/
@MyAnnon(className = "com.cars.domian.Student",methodName = "sleep")
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        //需求:可以创建任意类的对象,可以执行任意方法
       /*实现技术:
         1,配置文件
         2,反射    */
       //1,加载配置文件
       /* //1.1创建Properties对象
        Properties pro = new Properties();
        //1.2加载配置文件,转换为一个集合
        //1.2.1获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);*/
       //------------------------注解方式
        //获取该类的字节码对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        MyAnnon annotation = reflectTestClass.getAnnotation(MyAnnon.class);
        //2,获取配置文件中的数据
        /*String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");*/
        String className = annotation.className();
        String methodName = annotation.methodName();

        //3,加载该类进内存
        Class cls = Class.forName(className);
        //4,创建对象
        Object obj = cls.newInstance();
        //5,获取方法对象
        Method method = cls.getMethod(methodName);
        //6,执行方法
        method.invoke(obj);

    }

}
