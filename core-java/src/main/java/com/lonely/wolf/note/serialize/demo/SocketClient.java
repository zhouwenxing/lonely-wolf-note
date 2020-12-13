package com.lonely.wolf.note.serialize.demo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/29
 * @since jdk1.8
 */
public class SocketClient {

    public static void main(String[] args) {
        Socket socket = null;
        ObjectOutputStream out = null;
        try {
            socket = new Socket("localhost",8888);
            out = new ObjectOutputStream(socket.getOutputStream());
            SocketUser user = new SocketUser("0","张三");
            int i=0;
            while (true){
                if(i == 5){
                    break;
                }
                user.setId(i + "");
                out.writeObject(user);
                //为了正确的描绘对象之间的引用关系, ObjectOutputStream必须对自己序列化过的对象保持记性. 当再次遇到序列化过的对象的引用时,
                // ObjectOutputStream可以指明这个对象是序列化过的某某对象, 所以就不会再次序列化，而是复用之前的
                out.reset();//不调用reset则连续发送同一个对象及时属性变了也不会重新序列化
//                out.flush();
//                out.reset();
                i++;

            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != out){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != socket){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
