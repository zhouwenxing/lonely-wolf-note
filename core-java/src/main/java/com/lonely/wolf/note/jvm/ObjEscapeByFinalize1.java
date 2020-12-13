package com.lonely.wolf.note.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/25
 * @since jdk1.8
 */
public class ObjEscapeByFinalize1 {
    public static List<Object> list = null;

    public static void main(String[] args) throws InterruptedException {
        list = new ArrayList<>();
        //首次自救
        list = null;
        System.gc();
        Thread.sleep(1000);
        print();

    }

    static void print(){
        if (null == list){
            System.out.println("obj has been gc");
        }else{
            System.out.println("obj escape success");
        }
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("come in method：finalize");
        super.finalize();
        list = new ArrayList<>();
//        objEscapeByFinalize = new ObjEscapeByFinalize();//执行自救动作
    }
}
