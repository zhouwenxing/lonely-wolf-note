package com.lonely.wolf.note.mini.spring.v2.beans.support;

import com.lonely.wolf.note.mini.spring.v2.beans.config.WolfBeanDefinition;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/2/10
 * @since jdk1.8
 */
public class WolfBeanDefinitionReader {

    private Properties config;

    private final String SCAN_PACKAGE = "basePackage";

    private List<String> registryBeanClass = new ArrayList<>();


    public WolfBeanDefinitionReader(String... locations) {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(locations[0].replace("classpath:",""));
        try {
            config.load(in);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        doScanner(config.getProperty(SCAN_PACKAGE));
    }

    private void doScanner(String scanPackage) {
        URL url =this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.","/"));
        File files = new File(url.getFile());

        for (File file : files.listFiles()){
            if (file.isDirectory()){
                doScanner(scanPackage + "." + file.getName());
                continue;
            }
            if (file.getName().endsWith(".class")){
                String className = scanPackage + "." + file.getName().replaceAll(".class","");
                registryBeanClass.add(className);
            }
        }
    }

    //将扫描到的类封装成WolfBeanDefinition对象，并加入
    public List<WolfBeanDefinition> loadBeanDefinitions(){
        List<WolfBeanDefinition> result = new ArrayList<>();
        for (String className : registryBeanClass){
            try {
                Class<?> beanClass = Class.forName(className);

                WolfBeanDefinition wolfBeanDefinition = doCreateBeanDefinition(beanClass);
                if (null == wolfBeanDefinition){
                    continue;
                }
                result.add(wolfBeanDefinition);

                Class<?>[] interfaces = beanClass.getInterfaces();
                for (Class<?> c : interfaces){
                    result.add(doCreateBeanDefinition(c));
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return result;
    }


    private WolfBeanDefinition doCreateBeanDefinition(Class<?> clazz){
        try {
            if (!clazz.isInterface()){
                WolfBeanDefinition wolfBeanDefinition = new WolfBeanDefinition();
                wolfBeanDefinition.setBeanClassName(clazz.getName());
                wolfBeanDefinition.setFactoryBeanName(toLowerFirstLetterCase(clazz.getSimpleName()));
                wolfBeanDefinition.setLazyInit(false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public Properties getConfig(){
        return config;
    }



    /**
     * 将首字母转换为小写
     * @param className
     * @return
     */
    private String toLowerFirstLetterCase(String className) {
        if (StringUtils.isBlank(className)){
            return "";
        }
        String firstLetter = className.substring(0,1);
        return firstLetter.toLowerCase() + className.substring(1);
    }
}
