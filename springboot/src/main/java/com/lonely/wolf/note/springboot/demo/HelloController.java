package com.lonely.wolf.note.springboot.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/13
 * @since jdk1.8
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/demo")
    public String helloWorld(String name){
        return "Hello：" + name;
    }
}
