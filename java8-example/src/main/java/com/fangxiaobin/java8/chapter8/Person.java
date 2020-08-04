package com.fangxiaobin.java8.chapter8;

import java.util.Optional;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-04 17:01
 * <p>
 * description
 **/
public class Person {

    /*private Car car;

    public Car getCar() {
        return this.car;
    }*/


    private Optional<Car> car;

    public Optional<Car> getCar() {
        return this.car;
    }


}
