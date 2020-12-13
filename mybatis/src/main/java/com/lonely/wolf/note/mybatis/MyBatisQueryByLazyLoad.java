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
 * @date 2020/8/30
 * @since jdk1.8
 */
public class MyBatisQueryByLazyLoad {
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

        List<LwUser> userList = userMapper.selectUserAndJob();
        System.out.println(userList.size());//不会触发
        System.out.println(userList.get(0).getUserJobList().get(0).getCompanyName());//触发
//        System.out.println(null == userList ? "": JSONObject.toJSONString(userList));//触发


    }
}
