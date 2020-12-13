package com.lonely.wolf.note.mini.spring.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WolfAutowired {
    String value() default "";
}
