package com.lonely.wolf.note.design.pattern.prototype;

import com.lonely.wolf.note.design.pattern.prototype.impl.ShallowPrototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/19
 * @since jdk1.8
 */
public class TestShallowPrototype {
    public static void main(String[] args){
        //初始化一个原型实例对象ShallowPrototype
        ShallowPrototype shallowPrototype = new ShallowPrototype();
        shallowPrototype.setAge(18);
        shallowPrototype.setName("张三");
        List<String> phoneList = new ArrayList<>();
        phoneList.add("131XXXXXXXX");
        shallowPrototype.setPhoneList(phoneList);

        ShallowPrototype cloneShallowPrototype = (ShallowPrototype) shallowPrototype.clone();//克隆原型对象
        System.out.println(shallowPrototype.getPhoneList());
        System.out.println(cloneShallowPrototype.getPhoneList());
        System.out.println(shallowPrototype.getPhoneList() == cloneShallowPrototype.getPhoneList());//true

        //修改原对象中的属性phoneList
        List<String> list = shallowPrototype.getPhoneList();//获取到phoneList
        list.add("132XXXXXXXX");//再添加一个值
        System.out.println(shallowPrototype.getPhoneList());//输出：[131XXXXXXXX, 132XXXXXXXX]
        System.out.println(cloneShallowPrototype.getPhoneList());//输出：[131XXXXXXXX, 132XXXXXXXX]
    }

}
