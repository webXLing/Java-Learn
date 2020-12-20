package com.xl.mybatis.demo.handel;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateHandel extends BaseTypeHandler<Date> {
    @Override
    // java 类型 转变为数据库类型
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        // i 为参数位置  date 为那个参数
        long time = date.getTime();
        System.out.println("------"+date);
        preparedStatement.setLong(i,time);
    }

    @Override
    // 数据库 类型 转变为 java类型
    // resultSet 结果集
    // String 字段名

    // 将 bigint  转为date 日器
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        long aLong = resultSet.getLong(s);
        Date date = new Date(aLong);
        return date ;
    }

    @Override
    // 数据库 类型 转变为 java类型
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long aLong = resultSet.getLong(i);
        Date date = new Date(aLong);
        return date;
    }

    @Override
    // 数据库 类型 转变为 java类型
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
}
