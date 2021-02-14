package com.lonely.wolf.note.mini.spring.v2.beans.config;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/2/10
 * @since jdk1.8
 */
public class WolfBeanDefinition {
    private String beanClassName;

    private boolean isLazyInit;

    private String factoryBeanName;

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public boolean isLazyInit() {
        return isLazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        isLazyInit = lazyInit;
    }

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }
}
