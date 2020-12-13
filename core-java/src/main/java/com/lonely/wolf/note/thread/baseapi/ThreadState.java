package com.lonely.wolf.note.thread.baseapi;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/17
 * @since jdk1.8
 */
public class ThreadState {

//    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(()->{
//            System.out.println("我是t1线程");
//        });
//        System.out.println(t1.getState());//NEW
//        t1.start();
//        Thread.sleep(1000);
//        System.out.println(t1.getState());//TERMINATED
//    }


//    public static void main(String[] args) throws InterruptedException {
//        new Thread(()->{
//            while (true){
//                synchronized (ThreadState.class){
//                    System.out.println("我是t1线程");
//                    try {
//                        ThreadState.class.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        },"t1").start();
//
//        new Thread(()->{
//            while (true){
//                System.out.println("我是t2线程");
//                try {
//                    Thread.sleep(20000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"t2").start();
//
//    }




    static class BlockDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockDemo.class){
                while (true){

                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new BlockDemo(),"t3").start();
        new Thread(new BlockDemo(),"t4").start();
    }
}

