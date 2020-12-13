package com.lonely.wolf.note.serialize.demo;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/29
 * @since jdk1.8
 */
public class SocketServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            while (true){
                SocketUser  user = (SocketUser) input.readObject();
                System.out.println(JSONObject.toJSONString(user));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != serverSocket){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



    }


}
