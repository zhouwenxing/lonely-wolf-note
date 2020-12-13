package com.lonely.wolf.note.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环屏障，可以使一组线程达到一个同步点之前阻塞
 * @author zwx
 * @version 1.0
 * @date 2020/2/6
 * @since jdk1.8
 */
public class CycliBarrierDemo extends Thread{

    @Override
    public void run() {
        System.out.println("开始进行数据分析");
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new CycliBarrierDemo());
        new Thread(new DataImport(cyclicBarrier,"file1")).start();
        new Thread(new DataImport(cyclicBarrier,"file2")).start();
        new Thread(new DataImport(cyclicBarrier,"file3")).start();
    }

}


class DataImport extends Thread{
    private CyclicBarrier cyclicBarrier;
    private String path;

    public DataImport(CyclicBarrier cyclicBarrier, String path) {
        this.cyclicBarrier = cyclicBarrier;
        this.path = path;
    }

    @Override
    public void run() {
        System.out.println("开始导入:" + path + "数据");
        //TODO
        try {
            cyclicBarrier.await();//阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
