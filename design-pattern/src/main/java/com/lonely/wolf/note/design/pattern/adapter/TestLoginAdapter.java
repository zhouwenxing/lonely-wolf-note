package com.lonely.wolf.note.design.pattern.adapter;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/2
 * @since jdk1.8
 */
public class TestLoginAdapter {
    public static void main(String[] args) {
        LoginByOtherModeService loginByOtherModeService = new LoginByOtherModeService();
        loginByOtherModeService.loginByTelephone("131xxxxxxxx");
        loginByOtherModeService.loginByWechat("openid");

        LoginByTelephone loginByTelephone = new LoginByTelephone();//手机登录适配器
        loginByTelephone.loginByTelephone("131xxxxxxxx");

        LoginByWechat loginByWechat = new LoginByWechat();
        loginByWechat.loginByWechat("微信openid");//微信登录适配器

        LoginByQQ loginByQQ = new LoginByQQ();
        loginByQQ.loginByQQ("QQ号");//QQ登录适配器
    }
}
