package com.fangxiaobin.java8.chapter8;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-04 20:35
 * <p>
 * description
 **/
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;


    public Dish(String name, boolean vegetarian, int calories, Dish.Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Dish.Type getType() {
        return type;
    }


    public enum Type {MEAT,FISH,OTHER}

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }
}
