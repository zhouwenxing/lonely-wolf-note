package com.lonely.wolf.note.springboot.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/3/18
 * @since jdk1.8
 */
@Service
public class UserService {
//    @Autowired //属性注入
    private Wolf1Bean wolf1Bean;

    private Wolf2Bean wolf2Bean;

    private Wolf3Bean wolf3Bean;

//    @Autowired //构造器注入
//    public UserService(Wolf2Bean wolf2Bean) {
//        this.wolf2Bean = wolf2Bean;
//    }

//    @Autowired //setter方法注入
//    public void setWolf3Bean(Wolf3Bean wolf3Bean) {
//        this.wolf3Bean = wolf3Bean;
//    }
}
