package com.zyn.microblog.dao;


import com.zyn.microblog.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.Cacheable;

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
    //TODO: 注意当列名和类的属性名不一样时，应该使用数据库和类属性映射方法 http://computerdragon.blog.51cto.com/6235984/1399742
    @Select({"select", SELECT_FIELDS, " from", TABLE_NAME, "where user_id = #{userId}"})
    @Results (id = "user", value = {
            @Result(id = true, property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "realName", column = "real_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "headUrl", column = "head_url"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "email", column = "email"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "address", column = "address"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "introduction", column = "introduction"),
    })
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
    @ResultMap("user")
    User selectByNickname(String nickname);

    /**
     * 根据userId删除用户
     *
     * @param userId
     */
    @Delete({"delete from ", TABLE_NAME, "where user_id = #{userId}"})
    void deleteByUserId(int userId);


}
