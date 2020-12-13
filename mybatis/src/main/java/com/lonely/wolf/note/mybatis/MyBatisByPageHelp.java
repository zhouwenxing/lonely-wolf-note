package com.lonely.wolf.note.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lonely.wolf.note.mybatis.mapper.UserMapper;
import com.lonely.wolf.note.mybatis.model.LwUser;
import org.apache.ibatis.io.Resources;
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
public class MyBatisByPageHelp {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis-config配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        PageHelper.startPage(0,10);
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<LwUser> userList = userMapper.listAllUser();
        PageInfo<LwUser> pageList = new PageInfo<>(userList);
        System.out.println(null == pageList ? "": JSONObject.toJSONString(pageList));

    }
}
