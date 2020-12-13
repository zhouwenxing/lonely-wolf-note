package com.lonely.wolf.note.jvm;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/25
 * @since jdk1.8
 */
public class ObjEscapeByFinalize {
    public static ObjEscapeByFinalize objEscapeByFinalize = null;

    public static void main(String[] args) throws InterruptedException {
        objEscapeByFinalize = new ObjEscapeByFinalize();
        //首次自救
        objEscapeByFinalize = null;
        System.gc();
        Thread.sleep(1000);
        print();

        //再次自救
        objEscapeByFinalize = null;
        System.gc();
        Thread.sleep(1000);
        print();

    }

    static void print(){
        if (null == objEscapeByFinalize){
            System.out.println("obj has been gc");
        }else{
            System.out.println("obj escape success");
        }
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("come in method：finalize");
        super.finalize();
        objEscapeByFinalize = this;//只能自救1次
//        objEscapeByFinalize = new ObjEscapeByFinalize();//产生了新对象，可以无限自救
    }
}
