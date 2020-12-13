package com.lonely.wolf.note.design.pattern.singleton.hungry;

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
public class TestHungrySingleton2 {
    public static void main(String[] args) {
        HungrySingleton s1 = null;
        HungrySingleton s2 = HungrySingleton.getInstance();

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("HungrySingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("HungrySingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (HungrySingleton)ois.readObject();
            ois.close();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
