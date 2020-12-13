package com.lonely.wolf.note.design.pattern.adapter;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/2
 * @since jdk1.8
 */
public class LoginService {
    //为了便于理解，我们忽略账号注册功能，只考虑登录功能
    public void login(String userName,String password){
        System.out.println("登录成功，欢迎您" + userName);
    }
}
