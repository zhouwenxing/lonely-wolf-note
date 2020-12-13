package com.lonely.wolf.note.design.pattern.singleton.register;

import com.lonely.wolf.note.design.pattern.singleton.ConcurrentExecutor;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/21
 * @since jdk1.8
 */
public class TestContainerSingleton {
    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            ConcurrentExecutor.execute(new ConcurrentExecutor.RunHandler() {
                @Override
                public void handler() {
                    Object obj = ContainerSingleton.getBean("com.zwx.design.pattern.singleton.register.MyObject");
                    System.out.println(obj);
                }
            },50,20);
            long end = System.currentTimeMillis();
            System.out.println("总耗时：" + (end - start) + " ms.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
