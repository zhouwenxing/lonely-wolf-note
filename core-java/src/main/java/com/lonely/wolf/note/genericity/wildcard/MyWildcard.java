package com.lonely.wolf.note.genericity.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public class MyWildcard {
    public static void main(String[] args) {
//        List<?> list = new ArrayList<>();
//        list.add(null);//编译通过
//        list.add(1);//报错

//        List<?> list = MyWildcard.init();
//        Object obj = list.get(0);//通过
//        list.add(new Employee());//不通过

//        List<? extends Employee> list = MyWildcard.init();
//        Employee employee = list.get(0);//通过
//        list.add(new Manager());//不通过

        List<? super Employee> list = MyWildcard.init();
//        Employee employee = list.get(0);//编译不通过
        Object obj = list.get(0);//编译通过
        list.add(new Employee());//编译通过
    }

    public static List<? super Employee>  init(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee());
        return list;
    }


//    public static List<? extends Employee>  init(){
//        List<Employee> list = new ArrayList<>();
//        list.add(new Employee());
//        return list;
//    }

//    public static List<?>  init(){
//        List<Employee> list = new ArrayList<>();
//        list.add(new Employee());
//        return list;
//    }


}
