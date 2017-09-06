package com.zyn.microblog.dao;

import com.zyn.microblog.model.Friend;
import com.zyn.microblog.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 粉丝关注
 * Created by zyn on 2017/8/02.
 */
@Mapper
public interface FriendDao {
    String TABLE_NAME = " friend ";
    String INSERT_FIELDS = " user_id, cared_user_id, has_cared ";
    String SELECT_FIELDS = " user_id," + INSERT_FIELDS;

    /**
     * 插入user的粉丝careduser
     *
     * @param friend
     */
    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS, ") ", "values(#{userId}, #{caredUserId}, #{hasCared})"})
    void insertFriend(Friend friend);

    /**
     * @param userId
     * @param caredUserId
     * @return
     */
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where user_id=#{userId} and cared_user_id=#{caredUserId}"})
    @Results(id = "friend", value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "caredUserId", column = "cared_user_id"),
            @Result(property = "hasCared", column = "has_cared")
    })
    Friend selectFriendByUserIdAndCaredId(@Param("userId") int userId, @Param("caredUserId") int caredUserId);

    /**
     * 判断user和caredUser之间的关系
     *
     * @param userId
     * @param caredUserId
     * @return 0表示caredUser是user的粉丝，1表示相互关注
     */
    @Select({"select has_cared from", TABLE_NAME, "where user_id=#{userId} and cared_user_id=#{caredUserId}"})
    @ResultMap("friend")
    int selectStatusForUserAndCaredUser(@Param("userId") int userId, @Param("caredUserId") int caredUserId);

    /**
     * 查询userId的所有粉丝
     *
     * @param userId
     * @return
     */
    @Select({"select", UserDAO.TABLE_NAME, ".", UserDAO.SELECT_FIELDS, "from", TABLE_NAME, ",", UserDAO.TABLE_NAME,
            "where ", TABLE_NAME, ".user_id=#{userId} and ",
            UserDAO.TABLE_NAME, ".user_id=", TABLE_NAME, ".cared_user_id"})
    @ResultMap("com.zyn.microblog.dao.UserDAO.user")
    List<User> selectUserFansByUserId(int userId);


    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where user_id=#{userId}"})
    @ResultMap("com.zyn.microblog.dao.UserDAO.user")
    List<Friend> selectFriendsByUserId(int userId);
    /**
     * 删除user的粉丝careduser
     * @param userId
     * @param caredUserId
     */
    @Delete({"delete from ", TABLE_NAME, "where user_id=#{userId} and cared_user_id=#{caredUserId}"})
    void deleteFriendByUserIdAndCaredUserId(@Param("userId") int userId, @Param("caredUserId") int caredUserId);
}