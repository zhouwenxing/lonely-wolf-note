package com.lonely.wolf.note.mini.spring.controller;

import com.lonely.wolf.note.mini.spring.annotation.WolfAutowired;
import com.lonely.wolf.note.mini.spring.annotation.WolfController;
import com.lonely.wolf.note.mini.spring.annotation.WolfGetMapping;
import com.lonely.wolf.note.mini.spring.annotation.WolfRequestParam;
import com.lonely.wolf.note.mini.spring.service.HelloService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/2
 * @since jdk1.8
 */
@WolfController
public class HelloController {
    @WolfAutowired
    private HelloService helloService;

    @WolfGetMapping("/hello")
    public void query(HttpServletRequest request,HttpServletResponse response, @WolfRequestParam("name") String name) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("Hello：" + name);
    }
}
