package com.fangxiaobin.java8.chapter4;


import org.omg.Messaging.SyncScopeHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author :方晓彬
 * @Date :Created in 17:39 2020/7/31
 * description: stream
 * 创建stream
 */
public class CreateStream {


    public static void main(String[] args) {
        /*createStreamFromCollection().forEach(System.out::println);
        createStreamFromValues().forEach(System.out::println);
        */

//        createStreamFromArrays().forEach(System.out::println);
        createStreamFromFile();


    }

    private static Stream<String> createStreamFromCollection() {
        List<String> list = Arrays.asList("hello", "alex", "wangwenjun", "world", "stream");
        return list.stream();
    }


    private static Stream<String> createStreamFromValues() {
        return Stream.of("hello", "alex", "wangwenjun", "world", "stream");
    }


    private static Stream<String> createStreamFromArrays() {
        String[] strings = {"hello", "alex", "wangwenjun", "world", "stream"};
        return Arrays.stream(strings);
    }


    /**
     * 读取文件
     *
     * @return
     */
    private static Stream<String> createStreamFromFile() {
        Path path = Paths.get("D:\\Download\\零基础玩转微信小程序\\02-代码\\02-项目\\components\\SearchInput\\SearchInput.less");
        try (Stream<String> stringStream = Files.lines(path)) {
            stringStream.forEach(System.out::println);
            return stringStream;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 获取数字
     *
     * @return
     */
    private static Stream<Integer> createStreamFromIterator() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 2);
        return stream;
    }


    /**
     * 获取10个数字
     *
     * @return
     */
    private static Stream<Integer> createStreamFromIteratorByLimit() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 2).limit(10);
        return stream;
    }


    /**
     * 获取10个随机数
     *
     * @return
     */
    private static Stream<Double> createStreamFromGenerate() {
        return Stream.generate(Math::random).limit(10);
    }




}
