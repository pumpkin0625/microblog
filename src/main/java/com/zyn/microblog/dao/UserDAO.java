package com.zyn.microblog.dao;


import com.zyn.microblog.model.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by zyn on 2017/7/27.
 */
@Mapper
public interface UserDAO {
    String TABLE_NAME = " user";
    String INSERT_FIELDS = " user_name,nickname,real_name,password,salt,head_url,sex,email,phone,address,birthday,introduction ";
    String SELECT_FIELDS = " user_id,"+ INSERT_FIELDS;

    //插入一个用户
    @Insert({"insert into ",TABLE_NAME, "(",INSERT_FIELDS ,") values (#{userName},#{nickname},#{realName}," +
            "#{password},#{salt},#{headUrl},#{sex},#{email},#{phone},#{address},#{birthday},#{introduction})"})
    int addUser(User user);

    //检索某用户信息
    @Select({"select", SELECT_FIELDS, " from", TABLE_NAME , "where user_id = #{userId}"})
    User selectById(int userId);

    //用户修改个人信息
    @Update({"update",TABLE_NAME, "set real_name = #{realName},password = #{password},head_url = #{headUrl},sex = #{sex}," +
            "email = #{email},phone = #{phone}, address = #{address},birthday = #{birthday},introduction = #{introduction} " +
            "where user_id = #{userId}"})
    void updateUser(User user);

    //判断昵称是否已注册
    @Select({"select ", SELECT_FIELDS, "from",TABLE_NAME ,"where nickname = #{nickname}"})
    User selectByNickname(String nickname);

    //删除该用户
    @Delete({"delete from ", TABLE_NAME ,"where user_id = #{userId}"})
    void deleteByUserId(int userId);








}
