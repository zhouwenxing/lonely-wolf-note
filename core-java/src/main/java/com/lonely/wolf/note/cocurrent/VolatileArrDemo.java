package com.lonely.wolf.note.cocurrent;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/5/24
 * @since jdk1.8
 */
public class VolatileArrDemo {
    public static volatile User[] arr = new User[]{new User(18)};

    public static void main(String[] args) throws InterruptedException {
//        new Thread(()->{
//            while (arr[0].getAge() == 18){
//            }
//            System.out.println("end");
//        },"t1").start();
//        Thread.sleep(1000);//确保t1先进入while循环后主线程才修改变量
//        User user = arr[0];
//        user.setAge(19);
//        User user = new User(20);
//        arr[0] = user;
        System.out.println(Integer.numberOfLeadingZeros(0));

    }
}
