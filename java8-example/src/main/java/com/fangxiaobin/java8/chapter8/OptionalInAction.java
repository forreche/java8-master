package com.fangxiaobin.java8.chapter8;

import java.util.Optional;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-04 20:10
 * <p>
 * description
 *  funciton programming style
 *  you just tell how not do what
 **/
public class OptionalInAction {

    public static void main(String[] args) {
        System.out.println(getInsuranceNameByOptional(null));

        Optional.ofNullable(getInsuranceNameByOptional(null)).ifPresent(System.out::println);

    }

    private static String getInsuranceNameByOptional(Person person) {


        return Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown")
                ;
    }

}
