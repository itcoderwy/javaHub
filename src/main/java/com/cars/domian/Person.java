package com.cars.domian;

/**
 * @Description TODO
 * @Author Wy005
 * @Date 2020/7/27 9:22
 * @Version 1.0
 **/
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public void eat(){
        System.out.println("eat"+"--------");
    }
    public void eat(String food){
        System.out.println("eat"+"---"+food);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
