package com.lonely.wolf.note.mybatis.plugin;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/27
 * @since jdk1.8
 */
@Intercepts({@Signature(type = Executor.class,method = "isCached",args = {MappedStatement.class, CacheKey.class})})
public class MyPlugin implements Interceptor {

    /**
     * 这个方法会直接覆盖原有方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("成功拦截了Executor的query方法，在这里我可以做点什么");
        return invocation.proceed();//调用原方法
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);//把被拦截对象生成一个代理对象
    }

    @Override
    public void setProperties(Properties properties) {//可以自定义一些属性
        System.out.println("自定义属性:userName->" + properties.getProperty("userName"));
    }
}
