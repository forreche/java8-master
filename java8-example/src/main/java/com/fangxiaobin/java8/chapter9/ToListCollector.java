package com.fangxiaobin.java8.chapter9;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-05 04:03
 * <p>
 * description  自定义Collector 结合Stream的使用
 **/
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    private void log(final String log){
        System.out.println(Thread.currentThread().getName()+" - "+log);
    }

    @Override
    public Supplier<List<T>> supplier() {
        log("supplier");
        return ArrayList::new;
    }


    @Override
    public BiConsumer<List<T>, T> accumulator() {
        log("accumulator");

        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        log("combiner");

        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }


    @Override
    public Function<List<T>, List<T>> finisher() {
        log("finisher");

//        return Function.identity(); 两个相等的
        return t -> t;
    }

    @Override
    public Set<Characteristics> characteristics() {
        log("characteristics");

        return Collections.unmodifiableSet(
                EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT
                ));
    }
}
