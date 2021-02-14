package com.lonely.wolf.note.mini.spring.v2.context;

import com.lonely.wolf.note.mini.spring.annotation.WolfAutowired;
import com.lonely.wolf.note.mini.spring.annotation.WolfController;
import com.lonely.wolf.note.mini.spring.annotation.WolfService;
import com.lonely.wolf.note.mini.spring.v2.core.WolfBeanFactory;
import com.lonely.wolf.note.mini.spring.v2.beans.WolfBeanWrapped;
import com.lonely.wolf.note.mini.spring.v2.beans.config.WolfBeanDefinition;
import com.lonely.wolf.note.mini.spring.v2.beans.support.WolfBeanDefinitionReader;
import com.lonely.wolf.note.mini.spring.v2.beans.support.WolfDefaultListableBeanFactory;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/2/10
 * @since jdk1.8
 */
public class WolfApplicationContext extends WolfDefaultListableBeanFactory implements WolfBeanFactory {

    private String[] configLocations;
    private WolfBeanDefinitionReader wolfBeanDefinitionReader;
    //单例的IOC容器缓存
    private Map<String,Object> singletonObjects = new ConcurrentHashMap<>();
    //通用的IOC容器
    private Map<String,WolfBeanWrapped> factoryBeanInstanceCache = new ConcurrentHashMap<>();

    public WolfApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
        this.refresh();
    }

    @Override
    public Object getBean(String beanName) {
        //1.初始化
        Object instance = initBean(beanName,new WolfBeanDefinition());

        WolfBeanWrapped beanWrapper = new WolfBeanWrapped(instance);
        //2.注入
        populateBean(beanName,new WolfBeanDefinition(),new WolfBeanWrapped(instance));

        return null;
    }

    @Override
    public Object getBean(Class<?> clazz) {
        return null;
    }

    private void populateBean(String beanName, WolfBeanDefinition wolfBeanDefinition, WolfBeanWrapped wolfBeanWrapped) {
        Object instance = wolfBeanWrapped.getWrappedInstance();
        Class<?> clazz = wolfBeanWrapped.getWrappedClass();
        if (!(clazz.isAnnotationPresent(WolfController.class) || clazz.isAnnotationPresent(WolfService.class))){
            return;
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            if (!field.isAnnotationPresent(WolfAutowired.class)){
                continue;
            }
            WolfAutowired wolfAutowired = field.getAnnotation(WolfAutowired.class);
            String annotationValue = wolfAutowired.value();
            if (StringUtils.isBlank(annotationValue)){
                annotationValue = field.getType().getName();
            }
            field.setAccessible(true);

            if (null == this.factoryBeanInstanceCache.get(annotationValue)){
                continue;
            }
            try {
                field.set(instance,this.factoryBeanInstanceCache.get(annotationValue).getWrappedInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private Object initBean(String beanName, WolfBeanDefinition wolfBeanDefinition) {
        String className = wolfBeanDefinition.getBeanClassName();

        Object instance = null;
        try {
            if (this.singletonObjects.containsKey(className)){
                instance = this.singletonObjects.get(className);
                return instance;
            }
            Class<?> clazz = Class.forName(className);
            instance = clazz.newInstance();
            this.singletonObjects.put(className,instance);
            this.singletonObjects.put(wolfBeanDefinition.getFactoryBeanName(),instance);
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;

    }



    
    /**
     * 初始化
     */
    @Override
    protected void refresh() {
        //1.定位配置文件
        wolfBeanDefinitionReader = new WolfBeanDefinitionReader(this.configLocations);

        //2.加载定位到的配置文件
        List<WolfBeanDefinition> beanDefinitions = wolfBeanDefinitionReader.loadBeanDefinitions();

        //3.注册
        doRegisterBeanDefinition(beanDefinitions);

        //4.注入
        doAutowrited();
    }


    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }

    public int getBeanDefinitionCount(){
        return this.beanDefinitionMap.size();
    }


    //只处理非延时加载类
    private void doAutowrited() {
        for (Map.Entry<String,WolfBeanDefinition> entry: super.beanDefinitionMap.entrySet()){
            String beanName = entry.getKey();
            if (!entry.getValue().isLazyInit()){
                getBean(beanName);
            }
        }

    }


    private void doRegisterBeanDefinition(List<WolfBeanDefinition> beanDefinitions) {
        for (WolfBeanDefinition wolfBeanDefinition : beanDefinitions){
            super.beanDefinitionMap.put(wolfBeanDefinition.getFactoryBeanName(),wolfBeanDefinition);
        }
    }
}
