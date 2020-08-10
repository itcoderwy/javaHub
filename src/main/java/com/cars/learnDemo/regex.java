package com.cars.learnDemo;

/**
 * @Description 练习正则表达式
 * @Author Wy005
 * @Date 2020/8/10 8:42
 * @Version 1.0
 **/
public class regex {
    public static void main(String[] args) {
        check("12334");
    }

    public static boolean check(String str){
        boolean flag = true;
        //注意一个"."代表一个字符位置
        if(!str.matches(".....")){
            flag = false;
        }
        System.out.println(flag);
        return flag;
    }
}
