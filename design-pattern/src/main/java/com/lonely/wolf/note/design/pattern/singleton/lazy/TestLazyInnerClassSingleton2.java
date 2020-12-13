package com.lonely.wolf.note.design.pattern.singleton.lazy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/17
 * @since jdk1.8
 */
public class TestLazyInnerClassSingleton2 {
    public static void main(String[] args) {
        //序列化攻击内部类式单例
        LazyInnerClassSingleton s1 = null;
        LazyInnerClassSingleton s2 = LazyInnerClassSingleton.getInstance();

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("LazyInnerClassSingleton.text");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("LazyInnerClassSingleton.text");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (LazyInnerClassSingleton)ois.readObject();
            ois.close();

            System.out.println(s1 == s2);//输出：false

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
