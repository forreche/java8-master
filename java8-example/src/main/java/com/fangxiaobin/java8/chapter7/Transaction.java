package com.fangxiaobin.java8.chapter7;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-04 16:29
 * <p>
 * description
 **/
public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
}
