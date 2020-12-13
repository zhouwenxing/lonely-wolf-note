package com.lonely.wolf.note.design.pattern.adapter;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/17
 * @since jdk1.8
 */
public class LoginByWechat extends LoginService {
    @Override
    public void login(String userName, String password) {
        super.login(userName, password);
    }

    public void loginByWechat(String openid){
        //处理业务逻辑，如注册，存储微信账号信息等
        //为了兼容之前的账号密码登录，可以初始化与一个固定一个账号，并设置密码
        System.out.println("--------微信登录--------");
        this.login(openid,"设置好的密码");
    }
}
