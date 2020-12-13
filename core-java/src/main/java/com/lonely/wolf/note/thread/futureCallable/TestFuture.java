package com.lonely.wolf.note.thread.futureCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/5
 * @since jdk1.8
 */
public class TestFuture {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new MyCallable());

        System.out.println("任务是否完成：" + future.isDone());
        System.out.println(future.get());//阻塞直到返回结果
        System.out.println("任务是否完成：" + future.isDone());
        System.out.println("============end============");

        executorService.shutdown();
    }

}


class MyCallable implements Callable{
    @Override
    public Object call() throws Exception {
        Thread.sleep(2000);
        return "Hello World";
    }
}
