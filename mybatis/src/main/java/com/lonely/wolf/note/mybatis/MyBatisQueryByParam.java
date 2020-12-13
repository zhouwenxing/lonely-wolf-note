package com.lonely.wolf.note.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.lonely.wolf.note.mybatis.mapper.UserMapper;
import com.lonely.wolf.note.mybatis.model.LwUser;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/30
 * @since jdk1.8
 */
public class MyBatisQueryByParam {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis-config配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        /**
         * 相比较于session.selectList("com.xxx.UserMapper.listAllUser")来实现查询，
         * 下面这种方式会更灵活
         */
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.toString();
        ResultHandler resultHandler = new DefaultResultHandler();
        List<LwUser> userList = userMapper.listUserByUserName("孤狼1号",resultHandler);
        System.out.println(null == userList ? "": JSONObject.toJSONString(userList));

//        List<LwUser> userList2 = userMapper.listUserByTable("lw_user");
//        System.out.println(null == userList2 ? "": JSONObject.toJSONString(userList2));

        LwUser lwUserParam = new LwUser();
        List<LwUser> userList3 = userMapper.list(lwUserParam);
        System.out.println(null == userList3 ? "": JSONObject.toJSONString(userList3));
    }
}
