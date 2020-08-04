package com.fangxiaobin.java8.chapter6;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-04 03:48
 * <p>
 * description
 **/
public class StreamFind {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});


        /**
         * 查找全部
         */
        Optional<Integer> optional = stream.filter(i -> i % 2 == 0).findAny();
        System.out.println(optional.get());


        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Optional<Integer> optional2 = stream.filter(i -> i % 2 == 0).findFirst();

        int i1 = find(new Integer[]{1, 2, 3, 4, 5, 6, 7}, -1, i -> i < 10);
        System.out.println(i1);


    }


    /**
     * 查找全部 封装
     * 这样能够避免空指针问题
     */
    private static int find(Integer[] values, int defaultValue, Predicate<Integer> predicate) {
        for (int i : values) {
            if (predicate.test(i)) {
                return i;
            }
        }
        return defaultValue;
    }


}
