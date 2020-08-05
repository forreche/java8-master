package com.fangxiaobin.java8.chapter13;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-06 03:17
 * <p>
 * description
 **/
public class CompletableFutureInAction1 {

    private final static Random RANDOM = new Random(System.currentTimeMillis());


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();

        new Thread(() -> {
            double value = get();

            completableFuture.complete(value);


        }).start();

        System.out.println("-------........");
//        Optional.ofNullable(completableFuture.get()).ifPresent(System.out::println);


        /**
         * 没有主动的获取数据
         *
         * 通过流式的方式 存在值后返回出来
         */
        completableFuture.whenComplete((v, t) -> {
            Optional.ofNullable(v).ifPresent(System.out::println);

            Optional.ofNullable(t).ifPresent(x -> x.printStackTrace());
        });

    }


    /**
     * 包可见
     * @return
     */
    static double get() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RANDOM.nextDouble();
    }


}
