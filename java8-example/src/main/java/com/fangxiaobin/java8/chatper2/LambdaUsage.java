package com.fangxiaobin.java8.chatper2;

/**
 * @author :方晓彬
 * @Date :Created in 16:10 2020/7/31
 * description:
 */
public class LambdaUsage {


    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Hello");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello"));



    }

    private static void process(Runnable r) {
        r.run();
    }


}
