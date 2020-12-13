package com.lonely.wolf.note.mybatis.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/19
 * @since jdk1.8
 */
public class MyTypeHandler extends BaseTypeHandler<String> {

    /**
     * 设置参数
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int index, String param, JdbcType jdbcType) throws SQLException {
        System.out.println("设置参数->自定义typeHandler生效了");
        preparedStatement.setString(index,param);
    }

    /**
     * 根据列名获取结果
     */
    @Override
    public String getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        System.out.println("根据columnName获取结果->自定义typeHandler生效了");
        return resultSet.getString(columnName);
    }

    /**
     * 根据列的下标来获取结果
     */
    @Override
    public String getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        System.out.println("根据columnIndex获取结果->自定义typeHandler生效了");
        return resultSet.getString(columnIndex);
    }

    /**
     * 处理存储过程的结果集
     */
    @Override
    public String getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return callableStatement.getString(columnIndex);
    }
}
