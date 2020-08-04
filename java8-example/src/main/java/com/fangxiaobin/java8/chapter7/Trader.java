package com.fangxiaobin.java8.chapter7;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-04 16:28
 * <p>
 * description
 **/
public class Trader {

    private final String name;
    private final String city;


    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
