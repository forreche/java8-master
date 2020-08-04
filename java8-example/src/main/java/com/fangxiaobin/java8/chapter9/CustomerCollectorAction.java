package com.fangxiaobin.java8.chapter9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-05 04:47
 * <p>
 * description
 **/
public class CustomerCollectorAction {

    public static void main(String[] args) {

        Collector<String, List<String>, List<String>> collector = new ToListCollector<>();

        String[] arrs = new String[]{"Alex", "Wang", "Hello", "Lambda", "Collector", "Java8","Stream"};

        List<String> list = Arrays.asList("Alex", "Wang", "Hello", "Lambda", "Collector", "Java8", "Stream");

        List<String> result = Arrays.stream(arrs)
                .filter(s -> s.length() >= 4)
                .collect(collector);

        System.out.println(result);


    }


}
