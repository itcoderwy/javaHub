package com.cars.learnDemo;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.sql.DriverManager.println;

/**
 * @Description 定时任务得实现
 * @Author Wy005
 * @Date 2020/12/28 14:27
 * @Version 1.0
 **/
public class TimeTest {

    public static void main(String[] args) {
        useScheduledThreadPoolExecutorImplTimedTask();
    }

    /**
     * 使用这种方案，需要引入common-lang3的jar包
     *             <dependency>
     *          <groupId>org.apache.commons</groupId>
     *          <artifactId>commons-lang3</artifactId>
     *          <version>3.6</version>
     *      </dependency>
     */
    private static void useScheduledThreadPoolExecutorImplTimedTask(){
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(
                1, new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(false).build());
        // 第一个参数是任务，第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间,第四个参数是时间单位
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Local Time is " + new Date().toString());
            }
        }, 0L, 1L, TimeUnit.SECONDS);
    }
}
