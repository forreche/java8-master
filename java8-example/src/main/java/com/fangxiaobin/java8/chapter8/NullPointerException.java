package com.fangxiaobin.java8.chapter8;

/**
 * @program: java8-master
 * @author: fxb
 * @create: 2020-08-04 17:04
 * <p>
 * description   避免出现空指针
 **/
public class NullPointerException {

    public static void main(String[] args) {

//        String insuranceName = getInsuranceName(new Person());
//        System.out.println(insuranceName);


/*        String name = getInsuranceNameByDeepDoubts(new Person());
        System.out.println(name);*/

    }


    /**
     * 避免了空指针异常 但是需要做的逻辑判断很多 可读性差
     * @param person
     * @return
     */
    /*private static String getInsuranceNameByDeepDoubts(Person person){
        if(null != person){
            Car car = person.getCar();
            if(null != car ){
                Insurance insurance = car.getInsurance();
                if(null != insurance){
                    return insurance.getName();
                }
            }
        }

        return "UNKNOWN";
    }*/


    /**
     * 避免了空指针异常   多个返回值方式 避免了嵌套 但是还是啰嗦
     * @param person
     * @return
     */
    /*private static String getInsuranceNameByMultExit(Person person){
        final String defaultValue = "UNKNOWN";
        if(null == person){
            return defaultValue;
        }
        Car car = person.getCar();
        if(null == car){
            return defaultValue;
        }
        Insurance insurance = car.getInsurance();
        if(null == insurance){
            return defaultValue;
        }
        return insurance.getName();
    }*/



    /*private static String getInsuranceName(Person person){
        return person.getCar().getInsurance().getName();
    }
*/
}
