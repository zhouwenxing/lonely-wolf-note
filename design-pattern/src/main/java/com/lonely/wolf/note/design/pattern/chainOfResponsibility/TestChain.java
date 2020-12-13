package com.lonely.wolf.note.design.pattern.chainOfResponsibility;

/**
 * 测试责任链模式
 * @author zwx
 * @version 1.0
 * @date 2020/9/2
 * @since jdk1.8
 */
public class TestChain {
    public static void main(String[] args) {
        MyHandler accountHandler = new VerifyAccountHandler();
        MyHandler roleHanlder = new VerifyRoleHanlder();
        MyHandler permissionHanlder = new VerifyPermissionHanlder();

        accountHandler.next(roleHanlder);
        roleHanlder.next(permissionHanlder);

        LoginUser loginUser = new LoginUser();
        loginUser.setLoginName("孤狼1号");
        loginUser.setPassword("123456");
        loginUser.setRoleName("admin");
        loginUser.setPermission("admin");
        accountHandler.doHandler(loginUser);//从起点开始调用
    }
}
