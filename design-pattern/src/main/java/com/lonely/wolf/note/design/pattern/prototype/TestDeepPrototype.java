package com.lonely.wolf.note.design.pattern.prototype;

import com.lonely.wolf.note.design.pattern.prototype.impl.DeepPrototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/19
 * @since jdk1.8
 */
public class TestDeepPrototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype deepPrototype = new DeepPrototype();
        deepPrototype.setAge(18);
        deepPrototype.setName("张三");
        List<String> phoneList = new ArrayList<>();
        phoneList.add("131XXXXXXXX");
        deepPrototype.setPhoneList(phoneList);

        DeepPrototype cloneDeepProtoType = (DeepPrototype)deepPrototype.clone();
        System.out.println(deepPrototype.getPhoneList());//输出：[131XXXXXXXX]
        System.out.println(cloneDeepProtoType.getPhoneList());//输出：[131XXXXXXXX]
        System.out.println(deepPrototype.getPhoneList() == cloneDeepProtoType.getPhoneList());//false
        //修改原对象中的属性phoneList
        List<String> list = deepPrototype.getPhoneList();//获取到phoneList
        list.add("132XXXXXXXX");//再添加一个值
        System.out.println(deepPrototype.getPhoneList());//输出：[131XXXXXXXX, 132XXXXXXXX]
        System.out.println(cloneDeepProtoType.getPhoneList());//输出：[131XXXXXXXX]
    }
}
