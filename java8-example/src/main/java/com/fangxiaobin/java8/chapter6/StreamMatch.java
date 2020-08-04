package com.fangxiaobin.java8.chapter6;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-04 03:39
 * <p>
 * description
 **/
public class StreamMatch {

    public static void main(String[] args) {

        Stream<Integer> stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7});

        /**
         * allMatch 是否全部满足条件
         */
        boolean matched = stream.allMatch(i -> i > 10 );
        System.out.println(matched);


        /**
         * 是否存在满足条件的
         */
        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7});
        boolean anyMatch = stream.anyMatch(i -> i > 6);
        System.out.println(anyMatch);


        /**
         * noneMatch 不匹配
         */
        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7});
        boolean noneMatch = stream.noneMatch(i -> i < 0);
        System.out.println(noneMatch);

    }

}
