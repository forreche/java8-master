package com.fangxiaobin.java8.chapter10;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-05 16:40
 * <p>
 * description
 **/
public class SpliteratorInAction {

    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(0, 10);
        Spliterator.OfInt spliterator = intStream.spliterator();
        Consumer<Integer> consumer = i -> System.out.println(i);
        spliterator.forEachRemaining(consumer);
    }

}
