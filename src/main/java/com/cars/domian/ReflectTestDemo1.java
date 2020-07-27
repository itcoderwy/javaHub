package com.cars.domian;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description 反射练习
 * @Author Wy005
 * @Date 2020/7/27 9:26
 * @Version 1.0
 **/
public class ReflectTestDemo1 {
    public static void main(String[] args) throws Exception{
        //获取反射对象
        Class personClass = Person.class;
        Class personClass2 = Class.forName("com.cars.domian.Person");
        Person person = new Person();
        Class personClass3 = person.getClass();
        System.out.println(personClass == personClass2);
        System.out.println(personClass == personClass3);

        //获取所有成员变量
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
            declaredField.setAccessible(true);

        }
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person,"李强");
        System.out.println(person);

        //获取构造方法
        Constructor[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
            declaredConstructor.setAccessible(true);
        }
        Constructor ons = personClass.getDeclaredConstructor(String.class, int.class);
        ons.setAccessible(true);
        ons.newInstance("李强",26);
        System.out.println("通过反射赋值:"+person);

        //获取成员方法
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
           // declaredMethod.invoke(person, "香蕉");
            System.out.println(declaredMethod);
        }
        Method method = personClass.getDeclaredMethod("eat");
       method.setAccessible(true);
       method.invoke(person,222);
    }
}
