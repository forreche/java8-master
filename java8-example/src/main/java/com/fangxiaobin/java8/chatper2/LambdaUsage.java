package com.fangxiaobin.java8.chatper2;

import com.fangxiaobin.java8.chatper1.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

/**
 * @author :方晓彬
 * @Date :Created in 16:10 2020/7/31
 * description: lambda 用法
 */
public class LambdaUsage {

    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if (predicate.test(a)) {
                result.add(a);
            }
        }
        return result;
    }


    /**
     * function 接口的使用
     *
     * @param source
     * @param predicate
     * @return
     */
    private static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if (predicate.test(a.getWeight())) {
                result.add(a);
            }
        }

        return result;
    }


    private static String testFunction(Apple apple, Function<Apple, String> function) {
        return function.apply(apple);
    }

    private static Apple testBiFunction(String color, long weight, BiFunction<String, Long, Apple> fun) {
        return fun.apply(color, weight);
    }


    public static void main(String[] args) {
       /* Runnable r1 = () -> System.out.println("Hello");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello"));*/

        List<Apple> list = Arrays.asList(
                new Apple("green", 120),
                new Apple("red", 150),
                new Apple("green", 120),
                new Apple("green", 120),
                new Apple("green", 120)
        );
//        List<Apple> greenList = filter(list, (apple -> apple.getColor().equals("green")));
//        System.out.println(greenList);
//
//        List<Apple> result = filterByWeight(list, w -> w > 120);
//        System.out.println(result);


        Apple a = testBiFunction("Blue", 130, (s, w) -> new Apple(s, w));
        System.out.println(a);


    }

    private static void process(Runnable r) {
        r.run();
    }


}
