package com.lonely.wolf.note.design.pattern.factory.simple;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/10
 * @since jdk1.8
 */
public class SimpleFactory {
    public IProduct createProduct(String productType){
        if("apple".equals(productType)){
            return new Apple();
        }else if("orange".equals(productType)){
            return new Orange();
        }
        return null;
    }

    public IProduct createProduct2(Class<? extends IProduct> clazz) throws Exception {
        if (null == clazz){
            throw new Exception("无法识别的产品");
        }
        return clazz.newInstance();
    }
}
