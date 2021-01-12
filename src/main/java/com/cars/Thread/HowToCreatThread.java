package com.cars.Thread;

/**
 * @Description 创建线程的两种方式
 * @Author Wy005
 * @Date 2021/1/11 9:56
 * @Version 1.0
 **/
public class HowToCreatThread {
    static class Mythread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello-Mythread");
        }
    }

    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("Hello-MyRun");
        }
    }

    public static void main(String[] args) {
          new Mythread().start();
          new Thread((new MyRun())).start();
          new Thread(()-> System.out.println("Hello-Lambda")).start();
    }
   //1,继承thread  2,实现runnabl接口  3,通过线程池来启动Executors.newCacheThread


}
