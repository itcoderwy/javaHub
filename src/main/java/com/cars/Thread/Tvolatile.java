package com.cars.Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description volatile用法
 * @Author Wy005
 * @Date 2021/1/11 15:40
 * @Version 1.0
 **/
public class Tvolatile {
    volatile boolean running = true;
    void m() {
        System.out.println("m start");
        while (running) {

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        Tvolatile t = new Tvolatile();
        new Thread(t::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;



    }
}