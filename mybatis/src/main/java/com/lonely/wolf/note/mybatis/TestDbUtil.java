package com.lonely.wolf.note.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.lonely.wolf.note.mybatis.model.LwUser;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/30
 * @since jdk1.8
 */
public class TestDbUtil {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            //1、注册JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、打开连接，获得Connection对象
            connection = DriverManager.getConnection("jdbc:mysql://47.107.155.197:3891/lonely_wolf", "root", "xwkj*ylzs#2019");
        }catch (Exception e){
            e.printStackTrace();
        }
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select user_id,user_name from lw_user where user_id=?";
        //开启驼峰
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);
        //执行查询
        Object[] params = new Object[1];
        params[0] = "1";
        List<LwUser> lwUsers = queryRunner.query(connection,sql,params,new BeanListHandler<>(LwUser.class,processor));
        System.out.println(null == lwUsers ? "": JSONObject.toJSONString(lwUsers));
        DbUtils.closeQuietly(connection);
    }
}
