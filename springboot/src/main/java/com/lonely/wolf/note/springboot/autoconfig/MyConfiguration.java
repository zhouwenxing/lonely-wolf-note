package com.lonely.wolf.note.springboot.autoconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/3/21
 * @since jdk1.8
 */
@Configuration
@Import(TestImport.class)
public class MyConfiguration {
}
