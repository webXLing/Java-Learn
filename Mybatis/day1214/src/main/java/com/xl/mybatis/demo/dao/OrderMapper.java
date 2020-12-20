package com.xl.mybatis.demo.dao;

import com.sun.tools.corba.se.idl.constExpr.Or;
import com.xl.mybatis.demo.entity.Order;
import com.xl.mybatis.demo.entity.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    List<Order> myFindAll();

    // 直接一对一

//    方式1
    @Select("SELECT *,o.id oid from `order` o ,`user` u WHERE o.uid = u.id;")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user.id"),
            @Result(column = "name",property = "user.name"),
            @Result(column = "age",property = "user.age"),
            @Result(column = "money",property = "user.money")
    })
    List<Order> myFindAllAno();

//    方式2
    @Select("SELECT *,o.id oid from `order` o ,`user` u WHERE o.uid = u.id;")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(
                    property = "user",//要要封装的属性名
                    column = "uid",//通过该字段去查询
                    javaType = User.class ,// 要分装的实体类型
                    one = @One(select = "com.xl.mybatis.demo.dao.userMapper.findByIdAno")
            )
    })
    List<Order> myFindAllAno2();

    @Select("select * from `order` where uid=#{uid}")
    List<Order> findByUserIdAno(Integer uid);
}
