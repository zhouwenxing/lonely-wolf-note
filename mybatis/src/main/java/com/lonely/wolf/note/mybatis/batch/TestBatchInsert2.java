package com.lonely.wolf.note.mybatis.batch;


import com.lonely.wolf.note.mybatis.mapper.UserAddressMapper;
import com.lonely.wolf.note.mybatis.model.UserAddress;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/22
 * @since jdk1.8
 */
public class TestBatchInsert2 {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis-config配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH);

        try {
            List<UserAddress> userAddressList = new ArrayList<>();

            UserAddress userAddr = new UserAddress();
            userAddr.setAddress("广东深圳");
            userAddr.setId(1);
            userAddressList.add(userAddr);

            UserAddress userAddr2 = new UserAddress();
            userAddr2.setAddress("广东广州");
            userAddr2.setId(2);
            userAddressList.add(userAddr2);

            UserAddressMapper userAddressMapper = session.getMapper(UserAddressMapper.class);

            userAddressMapper.insert(userAddr);
            userAddressMapper.insert10(userAddr2);
            userAddressMapper.insert(userAddr);

            session.commit();
        }finally {
            session.close();
        }
    }

}
