package com.cars.Thread;
/**
 * @Description 加锁问题(分析程序的输出)
 *              业务逻辑能不加锁就不加锁 加锁会降低效率低100倍
 * @Author Wy005
 * @Date 2021/1/11 14:17
 * @Version 1.0
 **/

    public class T implements Runnable{

        private int count = 10;
        @Override
        public /*synchronized*/ void  run() {
            count --;
            System.out.println(Thread.currentThread().getName()+"--count="+count);
        }

    public static void main(String[] args) {
             T t = new T();
        for (int i = 0; i < 5; i++) {
            new Thread(t,"thread"+i).start();
        }
    }
}
