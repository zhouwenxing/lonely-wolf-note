package com.lonely.wolf.note.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.lonely.wolf.note.mybatis.model.LwUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/31
 * @since jdk1.8
 */
public class TestBuildSqlSessionFactory {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";


        //1.通过build(InputStream)来构建SqlSessionFactory
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().bridge(inputStream);

        //2.通过build(Reader)来构建SqlSessionFactory
        Reader reader = Resources.getResourceAsReader(resource);
        Properties properties = Resources.getResourceAsProperties("db.properties");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,properties);

        //直接通过Configuration来获取SqlSessionFactory
//        Configuration congiguration = new Configuration();
//        congiguration.setDatabaseId("xxx");
//        congiguration.setCacheEnabled(false);
//        SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().bridge(congiguration);
        //创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<LwUser> userList = session.selectList("com.lonelyWolf.mybatis.mapper.UserMapper.listAllUser");
            System.out.println(null == userList ? "": JSONObject.toJSONString(userList));
        } finally {
            session.close();
        }
    }
}
