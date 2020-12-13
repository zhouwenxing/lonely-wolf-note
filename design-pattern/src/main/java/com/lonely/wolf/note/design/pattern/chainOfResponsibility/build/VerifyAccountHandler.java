package com.lonely.wolf.note.design.pattern.chainOfResponsibility.build;

import com.lonely.wolf.note.design.pattern.chainOfResponsibility.LoginUser;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/2
 * @since jdk1.8
 */
public class VerifyAccountHandler extends BuildHandler {
    @Override
    public void doHandler(LoginUser loginUser) {
        if (StringUtils.isBlank(loginUser.getLoginName())){
            System.out.println("用户名不能为空");
            return;
        }
        if (StringUtils.isBlank(loginUser.getPassword())){
            System.out.println("密码不能为空");
            return;
        }
        if (!loginUser.getPassword().equals("123456")){
            System.out.println("密码不正确");
            return;
        }
        System.out.println("账号密码校验通过");
        next.doHandler(loginUser);
    }
}
