package com.lonely.wolf.note.design.pattern.chainOfResponsibility.build;

import com.lonely.wolf.note.design.pattern.chainOfResponsibility.LoginUser;

/**
 * 测试责任链模式
 * @author zwx
 * @version 1.0
 * @date 2020/9/2
 * @since jdk1.8
 */
public class TestBuildChain {
    public static void main(String[] args) {
        LoginUser loginUser = new LoginUser();
        loginUser.setLoginName("孤狼1号");
        loginUser.setPassword("123456");
        loginUser.setRoleName("admin");
        loginUser.setPermission("admin");

        BuildHandler.Builder builder = new BuildHandler.Builder();
        builder.addHanlder(new VerifyAccountHandler())
                .addHanlder(new VerifyRoleHanlder())
                .addHanlder(new VerifyPermissionHanlder());
        builder.build().doHandler(loginUser);
    }
}
