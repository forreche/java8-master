package com.fangxiaobin.java8.chapter5;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author :方晓彬
 * @Date :Created in 03:20 2020/8/4
 * description: StreamMap
 * Map
 */
public class StreamMap {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 1);

        List<Integer> result = list.stream().map(i -> i * 2).collect(Collectors.toList());
        System.out.println(result);


        System.out.println("===================================");
        listDish().stream().map(d -> d.getName()).forEach(System.out::println);

        List<String> collect = listDish().stream().map(d -> d.getName()).collect(Collectors.toList());
        System.out.println(collect);

        //flatMap flat 扁平化

        /**
         *使用Stream flat 去重
         */
        String[] words = {"Hello","World"};

        //先将字符串分割 转成Stream<String[]> {h,e,l,l,o} ,{w,o,r,l,d}
        Stream<String[]> stream = Arrays.stream(words).map(w -> w.split(""));

        //再转成 h,e,l,l,o,w,o,r,l,d  去重
        Stream<String> stringStream = stream.flatMap(Arrays::stream);

        stringStream.distinct().forEach(System.out::println);

    }


    private static List<Dish> listDish() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        return menu;
    }

}
