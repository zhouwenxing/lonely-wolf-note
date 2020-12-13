package com.lonely.wolf.note.design.pattern.adapter;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/17
 * @since jdk1.8
 */
public class LoginByQQ extends LoginService {
    @Override
    public void login(String userName, String password) {
        super.login(userName, password);
    }

    public void loginByQQ(String qqNum){
        //处理业务逻辑，如注册，存储qq账号信息等
        //为了兼容之前的账号密码登录，可以初始化与一个固定一个账号，并设置密码
        System.out.println("--------QQ登录--------");
        this.login(qqNum,"设置好的密码");
    }
}
