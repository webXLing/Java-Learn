package com.xl.mybatis.demo.dao;

import com.xl.mybatis.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface userMapper {
    public User findById(int age);

    List<User> findByCondition(User user);

    List<User> findByIds(List ids);

    void setUserBirthday(User user);

    List<User> findMyAll();

    List<User> selectUserOrder();

    List<User> selectUserRole();

//    ---- 使用注解

//    @Insert("insert INTO user values (#{birthday},#{name},#{age},#{money})")
    @Insert("insert INTO user values (#{id},#{name},#{age},#{money},#{birthday})")
    void inserAno(User user);
    @Update("UPDATE `user` SET name=#{name} WHERE where `id`=#{id}")
    void updateAno(User user);
    @Delete("DELETE FROM `user` WHERE id=#{id}")
    void deleteAno(Integer id);
    @Select("select * from user")
    List<User> selectAno();

    @Select("select * FROM `user` WHERE id=#{id}")
    User findByIdAno(Integer id);

//    注解一对多

    @Select("select * from user")
    @Results({
            @Result( id=true, column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(column = "money",property = "money"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.xl.mybatis.demo.dao.OrderMapper.findByUserIdAno")
            )

    })
    List<User> selectAndOrderAno();

    // 查询user 拥有的role
    @Select("select * from user")
    @Results({
            @Result( id=true, column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(column = "money",property = "money"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.xl.mybatis.demo.dao.RoleMapper.findByUid")
            )

    })
    List<User> selectAndRoleAno();

}
