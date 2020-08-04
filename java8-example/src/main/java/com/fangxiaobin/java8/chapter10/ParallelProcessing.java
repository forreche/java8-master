package com.fangxiaobin.java8.chapter10;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-05 04:58
 * <p>
 * description  ParallelStream 利用多核并行提高计算速度
 **/
public class ParallelProcessing {

    public static void main(String[] args) {

        /**
         * 获取cpu核数
         * System.out.println(Runtime.getRuntime().availableProcessors());
         */

        System.out.println("The best process time(normalAdd) => " + measureSumPerformance(ParallelProcessing::normalAdd, 100_000_000) + "MS");
//        System.out.println("The best process time(iterateStream) => " + measureSumPerformance(ParallelProcessing::iterateStream, 10_000_000) + "MS");
        System.out.println("The best process time(parallelStream3) => " + measureSumPerformance(ParallelProcessing::parallelStream3, 100_000_000) + "MS");


    }


    /**
     * 测量效率
     *
     * @param adder
     * @param limit
     * @return
     */
    private static long measureSumPerformance(Function<Long, Long> adder, long limit) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long startTimestamp = System.currentTimeMillis();

            long result = adder.apply(limit);

            long duration = System.currentTimeMillis() - startTimestamp;

//            System.out.println("The result of sum => " + result);

            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }


    /**
     * 并行执行
     * 慢的原因是需要拆箱
     *
     * @param limit
     * @return
     */
    private static long parallelStream(long limit) {
        return Stream.iterate(1L, i -> i + 1).parallel().limit(limit).reduce(0L, Long::sum);
    }


    /**
     * 拆箱的并行相加
     *
     * @param limit
     * @return
     */
    private static long parallelStream2(long limit) {
        return Stream.iterate(1L, i -> i + 1).mapToLong(Long::longValue).parallel().limit(limit).reduce(0L, Long::sum);
    }


    /**
     * 原方法提供的 并行执行
     *
     * @param limit
     * @return
     */
    private static long parallelStream3(long limit) {
        return LongStream.rangeClosed(1, limit).parallel().reduce(0L, Long::sum);
    }

    /**
     * 迭代相加
     *
     * @param limit
     * @return
     */
    private static long iterateStream(long limit) {
        return Stream.iterate(1L, i -> i + 1).limit(limit).reduce(0L, Long::sum);
    }

    /**
     * 加法
     *
     * @param limit
     * @return
     */
    private static long normalAdd(long limit) {
        long result = 0L;
        for (long i = 1L; i < limit; i++) {
            result += i;
        }
        return result;
    }

}
