package com.lonely.wolf.note.springboot.demo;

import com.lonely.wolf.note.springboot.inject.*;
import com.lonely.wolf.note.springboot.util.SpringContextUtil;
import com.lonely.wolf.note.springboot.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/13
 * @since jdk1.8
 */
@RestController
@RequestMapping("/hello")
@Qualifier
public class HelloController {

    @Autowired
    private UserService userService;
    @Autowired
    private InterfaceInject interfaceInject;
    @Autowired
    private InterfaceInject2 interfaceInject2;
    @Autowired
    private MyElement myElement;


    @GetMapping("/demo")
    public String helloWorld(String name){


        return "Hello：" + name;
    }

    @GetMapping("/bean")
    public Object getBean(){
        Wolf2Bean wolf2Bean = SpringContextUtil.getBeanByName("wolf2Bean");
        Wolf3Bean wolf3Bean = SpringContextUtil.getBeanByType(Wolf3Bean.class);

        return wolf2Bean.toString() + wolf3Bean.toString();
    }

    @GetMapping("/bean1")
    public Object getBean1(HttpServletRequest request){
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        Wolf1Bean wolf1Bean = (Wolf1Bean)applicationContext.getBean("wolf1Bean");

        return wolf1Bean.toString();
    }

    @GetMapping("/bean2")
    public Object getBean2(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());

        Wolf2Bean wolf2Bean = (Wolf2Bean)applicationContext.getBean("wolf2Bean");
        return wolf2Bean.toString();
    }


    @GetMapping("/bean3")
    public Object getBean3(){
        Wolf1Bean wolf1Bean = SpringUtil.getBean("wolf1Bean");
        return wolf1Bean.toString();
    }




}
