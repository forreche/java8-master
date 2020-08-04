package com.fangxiaobin.java8.chapter6;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-04 05:32
 * <p>
 * description NumericStream  减少内存的使用 提高性能
 **/
public class NumericStream {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        /**
         * 筛选 计算总和
         */
/*        Integer reduce = stream.filter(i -> i.intValue() > 3).reduce(0, Integer::sum);
        System.out.println(reduce);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        IntStream intStream = stream.mapToInt(i -> i.intValue());
        intStream.filter(i -> i > 3).sum();
        intStream.filter(i -> i > 3).reduce(0, (i, j) -> i + j);*/


        /**
         * 勾股定律的 NumericStream 实现 boxed
         */
        int a = 9;
        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed().map(x -> new int[]{a, x, (int) Math.sqrt(a * a + x * x)})
                .forEach(r -> System.out.println("a=" + r[0] + " ,b=" + r[1] + " ,c=" + r[2]));


        /**
         * 勾股定理的实现  mapToObj
         */
        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r -> System.out.println("a=" + r[0] + " ,b=" + r[1] + " ,c=" + r[2]));

    }

}
