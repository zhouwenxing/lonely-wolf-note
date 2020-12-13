package com.lonely.wolf.note.mini.spring.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WolfGetMapping {
    String value() default "";
}
