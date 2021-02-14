package com.lonely.wolf.note.mini.spring.v2.beans.support;

import com.lonely.wolf.note.mini.spring.v2.beans.config.WolfBeanDefinition;
import com.lonely.wolf.note.mini.spring.v2.context.WolfAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/2/10
 * @since jdk1.8
 */
public class WolfDefaultListableBeanFactory extends WolfAbstractApplicationContext {

    protected final Map<String, WolfBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    @Override
    protected void refresh() {
        super.refresh();
    }
}
