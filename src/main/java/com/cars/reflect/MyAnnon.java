package com.cars.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 自定义注解
 * @Author Wy005
 * @Date 2020/7/27 17:33
 * @Version 1.0
 **/
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnon {

    String className();
    String methodName();
}
