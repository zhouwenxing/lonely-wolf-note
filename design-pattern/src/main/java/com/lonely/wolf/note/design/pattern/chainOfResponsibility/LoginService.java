package com.lonely.wolf.note.design.pattern.chainOfResponsibility;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/6
 * @since jdk1.8
 */
public class LoginService {

    public void login(LoginUser loginUser){
        //1.校验账号密码
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
        //2.角色
        if(!"admin".equals(loginUser.getRoleName())){
            System.out.println("角色信息有误");
            return;
        }
        //3.校验权限
        if (!"admin".equals(loginUser.getPermission())){
            System.out.println("暂无权限");
            return;
        }
        System.out.println("校验通过，登录成功");
    }
}
