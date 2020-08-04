package com.fangxiaobin.java8.chapter8;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import static com.fangxiaobin.java8.chapter8.CollectorsAction.menu;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-05 02:06
 * <p>
 * description
 **/
public class CollectorsAction2 {

    public static void main(String[] args) {
        testGroupingByConcurrent();

        testGroupByConcurrentWithFunctionAndCollector();

        testJoiningWithDelimiter();

        testJoiningWithDelimiterAndPrefixAndSuffix();
    }


    /**
     * 按照type 分组
     */
    private static void testGroupingByConcurrent(){
        System.out.println("testGroupingByConcurrent");
        ConcurrentMap<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);

    }

    private static void testGroupByConcurrentWithFunctionAndCollector(){
        System.out.println("testGroupByConcurrentWithFunctionAndCollector");
        ConcurrentMap<Dish.Type, Double> collect = menu.stream()
                .collect(Collectors.groupingByConcurrent(Dish::getType, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testJoiningWithDelimiter(){
        System.out.println("testJoiningWithDelimiter");
        Optional.of(menu.stream().map(Dish::getName).collect(Collectors.joining(","))).ifPresent(System.out::println);
    }

    private static void testJoiningWithDelimiterAndPrefixAndSuffix(){
        System.out.println("testJoiningWithDelimiterAndPrefixAndSuffix");
        Optional.of(menu.stream().map(Dish::getName).collect(Collectors.joining(",","Name[","]"))).ifPresent(System.out::println);
    }




}
