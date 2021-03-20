package com.lonely.wolf.note.springboot.inject;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/3/18
 * @since jdk1.8
 */
@Component
//@Primary
//@ConditionalOnProperty(name = "lonely.wolf",havingValue = "test1")
public class Wolf1Bean implements IWolf{

}
