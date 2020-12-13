package com.lonely.wolf.note.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.lonely.wolf.note.mybatis.mapper.UserAddressMapper;
import com.lonely.wolf.note.mybatis.model.UserAddress;
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
public class TestMyBatisQuery {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis-config配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();


        try {
            UserAddressMapper userAddressMapper = session.getMapper(UserAddressMapper.class);
            List<UserAddress> list = userAddressMapper.selectUserAddress();
            System.out.println(JSONObject.toJSONString(list));
        }finally {
            session.close();
        }


    }
}
