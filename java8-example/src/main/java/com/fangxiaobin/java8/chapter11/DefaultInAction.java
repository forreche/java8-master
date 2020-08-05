package com.fangxiaobin.java8.chapter11;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-06 01:36
 * <p>
 * description  default方法解决多重继承冲突的三大原则
 * <p>
 * 1. class的 优先级 的最高的
 * 2. 上一级的接口 高于 上一级接口的父接口
 * 3. 最后如果还是没能分别出 继承 需要重写方法
 *
 *
 * 如果同时有类继承下来的方法，优先类来的方法
 * 采用继承链上，离接口实现类最近的那个接口的default method
 * 如果以上都不满足，实现类需要覆盖接口的default method，采用显示调用
 **/
public class DefaultInAction {

    /**
     * object 参数的方法
     *
     * @param o
     */
    private void confuse(Object o) {
        System.out.println("object");
    }


    /**
     * int[] 参数的方法
     *
     * @param i
     */
    private void confuse(int[] i) {
        System.out.println("int[]");
    }


    public static void main(String[] args) {
        DefaultInAction action = new DefaultInAction();

        /**
         * 这里会去调用 int[] 的方法
         * 因为 int[] 相对于object 更详细 所以优先调用 int[] 的方法
         *
         */
        action.confuse(null);

        /**
         * 这里的话 会调用到object 方法 因为参数更详细
         */
        int[] data = null;
        Object o = data;
        action.confuse(o);


        C c = new C();
        c.hello();


    }


    /**
     * 定义了一个接口
     */
    private interface A {
        default void hello() {
            System.out.println("A");
        }
    }

    /**
     * B 接口 继承了A 并且 重新 hello方法
     */
    private interface B extends A {

        @Override
        default void hello() {
            System.out.println("B");
        }
    }


    private static class C implements B, A {

    }


}
