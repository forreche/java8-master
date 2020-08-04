package com.fangxiaobin.java8.chapter5;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author :方晓彬
 * @Date :Created in 03:05 2020/8/4
 * description: StreamFilter
 * 过滤器
 */
public class StreamFilter {

    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        /**
         * 过滤器
         */
        List<Integer> result = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());

        System.out.println(result);


        /**
         * 去重
         */
        result = list.stream().distinct().collect(Collectors.toList());

        System.out.println(result);


        /**
         * 跳过 n个  skip(5)
         */
        result = list.stream().skip(5).collect(Collectors.toList());

        System.out.println(result);


        /**
         * 获取 n个  limit(50)
         */
        result = list.stream().limit(5).collect(Collectors.toList());

        System.out.println(result);
    }


}
