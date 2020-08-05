package com.fangxiaobin.java8.chapter12;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-06 01:55
 * <p>
 * description
 **/
public class FutureInAction {

    public static void main(String[] args) throws InterruptedException {
        Future<String> future = invoke(() -> {
            try {
                Thread.sleep(1000);
                return "I am finished. ";
            } catch (InterruptedException e) {
                return "Error";
            }
        });

        System.out.println(future.get());
        System.out.println(future.get());
        System.out.println(future.get());

        while (!future.isDone()){
            Thread.sleep(10);
        }
        System.out.println(future.get());

    }


    private static <T> Future<T> invoke(Callable<T> callable) {

        AtomicReference<T> result = new AtomicReference<>();
        AtomicBoolean finished = new AtomicBoolean(false);


        Thread t = new Thread(() -> {
            T value = callable.action();
            result.set(value);
            finished.set(true);
        });
        t.start();

        Future<T> future = new Future<T>() {

            @Override
            public T get() {
                return result.get();
            }

            @Override
            public boolean isDone() {
                return finished.get();
            }
        };
        return future;
    }

    private interface Future<T> {
        T get();

        boolean isDone();
    }

    private interface Callable<T> {
        T action();
    }

}
