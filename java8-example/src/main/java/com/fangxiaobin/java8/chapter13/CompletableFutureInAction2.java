package com.fangxiaobin.java8.chapter13;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-06 03:27
 * <p>
 * description
 **/
public class CompletableFutureInAction2 {

    public static void main(String[] args) throws InterruptedException {

        AtomicBoolean finished = new AtomicBoolean(false);

        /**
         * 申请一个异步任务
         */
        CompletableFuture.supplyAsync(CompletableFutureInAction1::get)
                .whenComplete((v,t) -> {
                    Optional.of(v).ifPresent(System.out::println);
                    finished.set(true);
                });

        System.out.println("-----i am no -----block-----");
        while (!finished.get()){
            Thread.sleep(1);
        }
    }

}
