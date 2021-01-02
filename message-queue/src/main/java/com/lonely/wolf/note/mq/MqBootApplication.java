package com.lonely.wolf.note.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/6
 * @since jdk1.8
 */
@SpringBootApplication(scanBasePackages = "com.lonely.wolf.note.mq")
public class MqBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MqBootApplication.class, args);
    }
}
