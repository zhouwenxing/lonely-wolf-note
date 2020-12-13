package com.lonely.wolf.note.serialize;

import com.lonely.wolf.note.serialize.demo.SocketUser1;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/1
 * @since jdk1.8
 */
public class TestSerialize {
    public static void main(String[] args) {
//        SocketUser socketUser = new SocketUser("1","张三丰");
        SocketUser1 socketUser1 = new SocketUser1(1,"张三丰");

        //Java序列化
        JavaSerialize javaSerialize = new JavaSerialize();
        byte[] byteArr = javaSerialize.serialize(socketUser1);
        System.out.println(byteArr.length);//108

        //XML序列化
        XMLSerializer xmlSerializer = new XMLSerializer();
        System.out.println(xmlSerializer.serialize(socketUser1).length);//110

        //FastJson序列化
//        FastJsonSerialize fastJsonSerialize = new FastJsonSerialize();
//        System.out.println(fastJsonSerialize.serialize(socketUser).length);//29
    }
}
