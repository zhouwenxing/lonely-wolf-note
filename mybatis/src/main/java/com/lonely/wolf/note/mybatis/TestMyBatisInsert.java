package com.lonely.wolf.note.mybatis;

import com.lonely.wolf.note.mybatis.mapper.UserAddressMapper;
import com.lonely.wolf.note.mybatis.model.UserAddress;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/30
 * @since jdk1.8
 */
public class TestMyBatisInsert {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis-config配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();


//        try {
//            UserAddress userAddress = new UserAddress();
//            userAddress.setAddress("广东深圳");
//            UserAddressMapper userAddressMapper = session.getMapper(UserAddressMapper.class);
//            int i = userAddressMapper.insert(userAddress);
//            System.out.println("插入成功数：" + i);
//            System.out.println("插入数据的主键为：" + userAddress.getId());
//            session.commit();
//        }finally {
//            session.close();
//        }

        try {
            UserAddress userAddress = new UserAddress();
            UserAddressMapper userAddressMapper = session.getMapper(UserAddressMapper.class);
            int i = userAddressMapper.insert2(userAddress);
            session.commit();
            System.out.println("插入成功数：" + i);
            System.out.println("插入数据的address为：" + userAddress.getAddress());
        }finally {
            session.close();
        }


    }
}
