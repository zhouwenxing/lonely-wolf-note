package com.lonely.wolf.note.serialize;

import com.alibaba.fastjson.JSONObject;
import com.lonely.wolf.note.serialize.demo.SocketUser;

import java.io.*;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/31
 * @since jdk1.8
 */
public class TestJavaSerialize {
    public static void main(String[] args) {
        SocketUser socketUser = new SocketUser("1","张三");
        serialize(socketUser);

        SocketUser socketUser2 = deSerialize();
        System.out.println(JSONObject.toJSONString(socketUser2));
    }


    static void serialize(SocketUser user){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("G:\\user")));
            out.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static SocketUser deSerialize(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("G:\\user")));
            return (SocketUser) in.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
