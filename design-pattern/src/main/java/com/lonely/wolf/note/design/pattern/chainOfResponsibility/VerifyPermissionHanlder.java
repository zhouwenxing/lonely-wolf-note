package com.lonely.wolf.note.design.pattern.chainOfResponsibility;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/2
 * @since jdk1.8
 */
public class VerifyPermissionHanlder extends MyHandler {
    @Override
    public void doHandler(LoginUser loginUser) {
        if (!"admin".equals(loginUser.getPermission())){
            System.out.println("暂无权限");
            return;
        }
        System.out.println("权限校验通过，登录成功");
    }
}
