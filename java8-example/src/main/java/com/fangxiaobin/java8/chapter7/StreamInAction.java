package com.fangxiaobin.java8.chapter7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-04 16:30
 * <p>
 * description  StreamInAction API
 **/
public class StreamInAction {

    public static void main(String[] args) {

        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader raoul = new Trader("Raoul", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2010, 950)
        );

        /**
         * 获取 年份内 所有的交易 并按名字排序
         */
        List<Transaction> result = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println(result);

        /**
         * what are all the unique cities where the traders work
         * 所有的工作地点
         */
        transactions.stream().map(t -> t.getTrader().getCity())
                .distinct().forEach(System.out::println);


        /**
         * find all traders from cambridge and sort them by name
         * 找到剑桥的所有交易者，并按名字分类
         */
        transactions.stream().map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        /**
         * return a string of all traders names sorted alphabetically
         * 返回按字母顺序排序的所有交易者名称的字符串
         */
        String reduce = transactions.stream().map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (name1, name2) -> name1 + name2);

        System.out.println(reduce);


        /**
         * Are any traders based in Milan
         * 是否存在有米兰的交易者
         */
        boolean milan = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        boolean milan1 = transactions.stream().map(Transaction::getTrader).anyMatch(t -> t.getCity().equals("Milan"));

        System.out.println(milan);
        System.out.println(milan1);


        /**
         * print all transactions values from the traders living in cambridge
         * 打印居住在剑桥的交易员的所有交易者
         */
        transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);


        /**
         * whats the highest value of all the transactions
         * 所有交易员的最高价值是多少
         */
        Optional<Integer> reduce1 = transactions.stream().map(Transaction::getValue).reduce((i, j) -> i > j ? i : j);
        System.out.println(reduce1.get());




    }

}
