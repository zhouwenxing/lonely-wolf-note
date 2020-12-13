package com.lonely.wolf.note.design.pattern.strategy;

import com.lonely.wolf.note.design.pattern.strategy.impl.AliPayStrategy;
import com.lonely.wolf.note.design.pattern.strategy.impl.WechatPayStrategy;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/3/2
 * @since jdk1.8
 */
public enum PayEnum {
    AliPay("aliPay",new AliPayStrategy()),
    WechatPay("wechatPay",new WechatPayStrategy());

    private String key;
    private IPayStrategy value;

    PayEnum(String key, IPayStrategy value) {
        this.key = key;
        this.value = value;
    }

    public static IPayStrategy getValue(String key){
        for (PayEnum payEnum : PayEnum.values()){//遍历枚举类
            if (payEnum.key.equals(key)){
                return payEnum.value;
            }
        }
       return new AliPayStrategy();//没有合适key则默认阿里支付
    }

}
