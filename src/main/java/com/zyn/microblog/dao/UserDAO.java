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
    String SELECT_FIELDS = " user_id," + INSERT_FIELDS;

    /**
     * 插入用户
     *
     * @param user 用户类
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{userName},#{nickname},#{realName}," +
            "#{password},#{salt},#{headUrl},#{sex},#{email},#{phone},#{address},#{birthday},#{introduction})"})
    //类的主键名，加上这句话后，user对象中的userId将会被设置为自动生成的主键
    @Options(keyProperty = "userId", useGeneratedKeys = true)
    void addUser(User user);

    /**
     * 根据userId查询用户
     *
     * @param userId
     * @return 查询到的用户，不存在返回null
     */
    @Select({"select", SELECT_FIELDS, " from", TABLE_NAME, "where user_id = #{userId}"})
    User selectById(int userId);

    /**
     * 更新用户
     *
     * @param user
     */
    @Update({"update", TABLE_NAME, "set real_name = #{realName},password = #{password},head_url = #{headUrl},sex = #{sex}," +
            "email = #{email},phone = #{phone}, address = #{address},birthday = #{birthday},introduction = #{introduction} " +
            "where user_id = #{userId}"})
    void updateUser(User user);

    /**
     * 根据用户昵称查询用户
     *
     * @param nickname 用户昵称，唯一存在
     * @return 查询到的用户，若不存在返回null。
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where nickname = #{nickname}"})
    User selectByNickname(String nickname);

    /**
     * 根据userId删除用户
     *
     * @param userId
     */
    @Delete({"delete from ", TABLE_NAME, "where user_id = #{userId}"})
    void deleteByUserId(int userId);


}
