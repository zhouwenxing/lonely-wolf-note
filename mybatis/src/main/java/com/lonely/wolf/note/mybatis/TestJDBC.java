package com.lonely.wolf.note.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.lonely.wolf.note.mybatis.model.LwUser;
import java.sql.*;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/30
 * @since jdk1.8
 */
public class TestJDBC {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1、注册JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、打开连接，获得Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://47.107.155.197:3891/lonely_wolf", "root", "xwkj*ylzs#2019");
            //3、获得Statement对象
            stmt = conn.createStatement();

            //4、执行sql语句获取结果集ResultSet
            String sql = "select user_id,user_name from lw_user where user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"1");
            ResultSet rs = ps.executeQuery();
//            ResultSet rs = stmt.executeQuery(sql);
            //5、将结果集转换为Java对象  rs.previous()
            while (rs.next()) {
                LwUser lwUser = new LwUser();
                String userId = rs.getString("user_id");
                String userName = rs.getString("user_name");
                lwUser.setUserId(userId);
                lwUser.setUserName(userName);
                System.out.println(JSONObject.toJSONString(lwUser));
            }
            //6、关闭资源
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
