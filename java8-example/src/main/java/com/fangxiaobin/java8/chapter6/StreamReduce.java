package com.fangxiaobin.java8.chapter6;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-04 04:04
 * <p>
 * description  StreamReduce 聚合功能
 **/
public class StreamReduce {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});


        /**
         * 相加
         * identity 本身
         */
        Integer result = stream.reduce(0, (i, j) -> i + j);
        System.out.println(result);


        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce((i, j) -> i + j).ifPresent(System.out::println);


        /**
         * 循环对比 返回最大的
         */
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce((i, j) -> {
            return i > j ? i : j;
        }).ifPresent(System.out::println);


        /**
         * 循环对比 返回最大的
         */
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce(Integer::max).ifPresent(System.out::println);

        /**
         * 循环对比 返回最小的
         */
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce(Integer::min).ifPresent(System.out::println);


        /**
         * 循环对比 返回最小的 相当于上面的
         */
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce((i, j) -> i > j ? j : i).ifPresent(System.out::println);


    }

}
