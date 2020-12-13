package com.lonely.wolf.note.design.pattern.chainOfResponsibility;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/2
 * @since jdk1.8
 */
public class VerifyRoleHanlder extends MyHandler {
    @Override
    public void doHandler(LoginUser loginUser) {
        if(!"admin".equals(loginUser.getRoleName())){
            System.out.println("角色信息有误");
            return;
        }
        System.out.println("角色信息校验通过");
        next.doHandler(loginUser);
    }
}
