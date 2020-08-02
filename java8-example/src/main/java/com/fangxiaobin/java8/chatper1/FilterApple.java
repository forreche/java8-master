package com.fangxiaobin.java8.chatper1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :方晓彬
 * @Date :Created in 15:29 2020/7/31
 * description:
 */
public class FilterApple {


    public interface AppleFilter{
        boolean filter(Apple apple);
    }

    public static List<Apple> findApple(List<Apple> apples,AppleFilter appleFilter){
        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if(appleFilter.filter(apple)){
                list.add(apple);
            }
        }
        return list;
    }

    public static class GreenAndWeightFilter implements AppleFilter{

        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("green") && apple.getWeight() >= 160);
        }
    }





    public static List<Apple> findGreenApple(List<Apple> apples) {
        List<Apple> list = new ArrayList<>();


        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())){
                list.add(apple);
            }
        }
        return list;
    }
    public static List<Apple> findApple(List<Apple> apples,String color) {
        List<Apple> list = new ArrayList<>();


        for (Apple apple : apples) {
            if (color.equals(apple.getColor())){
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("green",150),
                new Apple("yellow",170),
                new Apple("green",180),
                new Apple("red",150)
                );

//        List<Apple> greenApples = findGreenApple(list);
//        assert greenApples.size() == 2;
//        System.out.println(greenApples);

/*
        List<Apple> apple = findApple(list, new GreenAndWeightFilter());
        System.out.println(apple);
        findApple(list,new GreenAndWeightFilter());
*/

/*
        List<Apple> result = findApple(list, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return "yellow".equals(apple.getColor());
            }
        });
        System.out.println(result);*/


        List<Apple> lambdaResult = findApple(list ,apple1 -> {
            return apple1.getColor().equals("green");
        });

        System.out.println(lambdaResult);


    }

}
