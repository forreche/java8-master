package com.fangxiaobin.java8.chapter8;

import java.util.Optional;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-04 17:02
 * <p>
 * description
 **/
public class Car {

   /* private Insurance insurance;

    public Insurance getInsurance() {
        return this.insurance;
    }*/


    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return this.insurance;
    }
}
