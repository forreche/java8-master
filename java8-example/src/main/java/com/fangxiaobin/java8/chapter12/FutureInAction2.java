package com.fangxiaobin.java8.chapter12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-06 02:11
 * <p>
 * description jdk 自带的 future ，callable ,executorService 介绍
 **/
public class FutureInAction2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        /**
         * 创建一个线程池 只有一个可复用的线程
         * 始终等待 任务结束
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        /**
         *
         */
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(10_000L);
                return "I am finished. ";
            } catch (InterruptedException e) {
                return "Error";
            }
        });

        /**
         * 如果没有结果 会一直阻塞
         */
        String value = future.get();
        System.out.println(value);
        executorService.shutdown();

    }

}
