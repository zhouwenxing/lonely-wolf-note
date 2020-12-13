package com.lonely.wolf.note.thread.futureCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/5
 * @since jdk1.8
 */
public class TestFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyCallableTask());
        Thread t1 = new Thread(futureTask);
        t1.start();

        System.out.println(futureTask.get());

        FutureTask futureTask2 = new FutureTask(new MyRunnable(),"2");
        Thread t2 = new Thread(futureTask2);
        t2.start();
        System.out.println(futureTask2.get());
    }
}

class MyCallableTask implements Callable {
    @Override
    public Object call() throws Exception {
        return "Hello World";
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello Word，I'm Runnable");
    }
}
