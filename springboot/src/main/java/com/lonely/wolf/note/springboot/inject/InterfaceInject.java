package com.lonely.wolf.note.springboot.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/3/18
 * @since jdk1.8
 */
@Component
public class InterfaceInject {
    @Resource(name = "wolf2Bean",type = Wolf2Bean.class)
    private IWolf iWolf;
    @Autowired
    List<IWolf> list;
    @Autowired
    private Map<String,IWolf> map;

    @Autowired
    private ApplicationContext applicationContext;

    public Object getBean(){
        return applicationContext.getBean("wolf1Bean");
    }
}
