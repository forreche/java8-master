package com.fangxiaobin.java8.chatper2;

import com.fangxiaobin.java8.chatper1.Apple;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @author :方晓彬
 * @Date :Created in 15:54 2020/7/31
 * description:
 *
 * 函数式接口@FunctionalInterface
 * 接口有且仅有一个抽象方法
 * 允许定义静态方法
 * 允许定义默认方法
 * 允许java.lang.Object中的public方法
 * 该注解不是必须的，如果一个接口符合"函数式接口"定义，那么加不加该注解都没有影响。加上该注解能够更好地让编译器进行检查。如果编写的不是函数式接口，但是加上了@FunctionInterface，那么编译器会报错
 *
 */
public class LambdaExpression {

    public static void main(String[] args) {

//        Function<String,Integer> function = s->s.length();
        /**
         * lambda表达式
         *
         * （parameters) -> expression
         * (parameters) -> {statments;}
         * () -> {}
         * () -> { return "hello" }
         *
         */


        Comparator<Apple> byColor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        List<Apple> list =  Collections.emptyList();
        list.sort(byColor);

        Comparator<Apple> byColor2 = (o1,o2) -> o1.getColor().compareTo(o2.getColor());

//        Function<String,Integer>  filambda =



    }




}
