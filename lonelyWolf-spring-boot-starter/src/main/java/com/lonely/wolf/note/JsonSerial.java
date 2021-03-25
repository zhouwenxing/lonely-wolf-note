package com.lonely.wolf.note;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/3/21
 * @since jdk1.8
 */
public class JsonSerial {

    public <T> String serial(T t){
        return JSONObject.toJSONString(t);
    }
}
