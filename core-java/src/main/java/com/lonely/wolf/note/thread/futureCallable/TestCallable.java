package com.lonely.wolf.note.thread.futureCallable;

import java.util.concurrent.Callable;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/4
 * @since jdk1.8
 */
public class TestCallable {
    public static void main(String[] args) throws Exception {
        Callable<String> callable = () -> {
            return "Hello World1";
        };


        System.out.println(callable.call());

        Callable<String> callable1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello World2";
            }
        };
        System.out.println(callable1.call());
    }
}
