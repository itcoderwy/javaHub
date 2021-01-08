package com.cars.lambda;

/**
 * @Description 联系lambda表达式
 * @Author Wy005
 * @Date 2020/12/29 16:23
 * @Version 1.0
 **/
public class Demo1 {
    public static void main(String[] args) {
        Info info = (s)-> System.out.println(s);
        info.print("hello lambda!");
    }   
}
interface Info{
    void print(String str);
}
