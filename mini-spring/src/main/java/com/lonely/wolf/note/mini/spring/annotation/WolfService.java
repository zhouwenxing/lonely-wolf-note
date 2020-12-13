package com.lonely.wolf.note.mini.spring.annotation;

import java.lang.annotation.*;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/2
 * @since jdk1.8
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WolfService {
    String value() default "";
}
