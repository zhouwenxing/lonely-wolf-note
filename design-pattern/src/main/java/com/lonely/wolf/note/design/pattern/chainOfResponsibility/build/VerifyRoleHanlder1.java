package com.lonely.wolf.note.design.pattern.chainOfResponsibility.build;

import com.lonely.wolf.note.design.pattern.chainOfResponsibility.LoginUser;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/2
 * @since jdk1.8
 */
public class VerifyRoleHanlder1 extends BuildHandler1 {
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
