package com.lonely.wolf.note.design.pattern.prototype.impl;

import java.io.*;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/19
 * @since jdk1.8
 */
public class DeepPrototype implements Serializable {
    private String name;

    private int age;

    private List<String> phoneList;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }

    public Object clone(){
        return this.deepClone();
    }

    public DeepPrototype deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            DeepPrototype clone = (DeepPrototype)ois.readObject();

            return clone;
        }catch (Exception e){
            System.out.println("深克隆异常");
            e.printStackTrace();
        }
       return null;
    }
}
