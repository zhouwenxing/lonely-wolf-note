package com.lonely.wolf.note.mini.spring.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WolfRequestParam {
    String value() default "";
}
