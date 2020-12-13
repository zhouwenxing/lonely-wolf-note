package com.lonely.wolf.note.design.pattern.chainOfResponsibility.build;

import com.lonely.wolf.note.design.pattern.chainOfResponsibility.LoginUser;

/**
 * 测试责任链模式
 * @author zwx
 * @version 1.0
 * @date 2020/9/2
 * @since jdk1.8
 */
public class TestBuildChain1 {
    public static void main(String[] args) {
        LoginUser loginUser = new LoginUser();
        loginUser.setLoginName("孤狼1号");
        loginUser.setPassword("123456");
        loginUser.setRoleName("admin");
        loginUser.setPermission("admin");

        Builder1<BuildHandler1> builder = new Builder1();
        builder.addHanlder(new VerifyAccountHandler1())
                .addHanlder(new VerifyRoleHanlder1())
                .addHanlder(new VerifyPermissionHanlder1());
        builder.build().doHandler(loginUser);
    }
}
