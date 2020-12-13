package com.lonely.wolf.note.design.pattern.adapter;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/17
 * @since jdk1.8
 */
public class LoginByTelephone extends LoginService {

    @Override
    public void login(String userName, String password) {
        super.login(userName, password);
    }

    public void loginByTelephone(String telephone){
        //处理业务逻辑，如注册，存储手机号校验验证码等
        //为了兼容之前的账号密码登录，可以初始化与一个固定一个账号，并设置密码
        System.out.println("--------手机登录--------");
        this.login(telephone,"设置好的密码");
    }


}
