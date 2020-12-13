package com.lonely.wolf.note.serialize.demo;

import java.io.Serializable;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/29
 * @since jdk1.8
 */
public class SocketUser implements Serializable{

    public SocketUser(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private String id;
    private static String name;

//    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
//        s.defaultWriteObject();
//        s.writeObject(name);
//    }
//
//    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
//        s.defaultReadObject();
//        name=(String)s.readObject();
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
