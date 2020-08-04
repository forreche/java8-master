package com.fangxiaobin.java8.chapter8;

import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;

import java.util.Optional;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-04 17:15
 * <p>
 * description 使用Optional API
 * Optional 对 Object 包装
 **/
public class OptionalUsage {

    public static void main(String[] args) {

/*        Optional<Insurance> insuranceOptional = Optional.<Insurance>empty();
        insuranceOptional.get();*/

/*        Optional<Insurance> obj = Optional.ofNullable(null);
        obj.orElseGet(Insurance::new);
        obj.orElse(new Insurance());
        obj.orElseThrow(RuntimeException::new);*/



    }

    private static String getInsuranceName(Insurance insurance){
        if(null == insurance){
            return "unknown";
        }
        return insurance.getName();
    }

    private static String getInsuranceNameByOptional(Insurance insurance){
        return Optional.ofNullable(insurance).map(Insurance::getName).orElse("unknown");
    }

}
