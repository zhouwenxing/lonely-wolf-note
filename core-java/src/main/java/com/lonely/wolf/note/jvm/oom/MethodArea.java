package com.lonely.wolf.note.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 方发区-->OOM
 * @author zwx
 * @version 1.0
 * @date 2020/8/5
 * @since jdk1.8
 */
public class MethodArea {
    public static void main(String[] args) {
        //jdk1.7及之前
//        List<String> list = new ArrayList<>();
//        int i = 9999;
//        while (true){
//            list.add(String.valueOf(i++).intern());
//        }

        //jdk1.8
        List<Class<?>> list=new ArrayList<Class<?>>();
        while(true){
            list.addAll(MetaspaceUtil.createClasses());
        }

    }
}
