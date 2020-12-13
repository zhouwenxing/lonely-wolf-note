package com.lonely.wolf.note.mybatis;


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
 * @date 2020/9/25
 * @since jdk1.8
 */
public class TestMyBatisCache {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis-config配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession对象
        SqlSession session1 = sqlSessionFactory.openSession();
        UserMapper userMapper1 = session1.getMapper(UserMapper.class);
        List<LwUser> userList =  userMapper1.selectUserAndJob();
        session1.commit();//注意这里需要commit,否则缓存不会生效

        SqlSession session2 = sqlSessionFactory.openSession();
        UserMapper userMapper2 = session2.getMapper(UserMapper.class);
        List<LwUser> userList2 =  userMapper2.selectUserAndJob();

//        CacheKey cacheKey = new CacheKey();
//        PerpetualCache localCache = new PerpetualCache("1");
//        localCache.putObject(cacheKey, EXECUTION_PLACEHOLDER);
//        List<Object> list = (List<Object>) localCache.getObject(cacheKey);
//        System.out.println(11);
    }
}
