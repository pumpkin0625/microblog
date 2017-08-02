package com.zyn.microblog.dao;

import com.zyn.microblog.model.Friend;
import com.zyn.microblog.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 粉丝关注
 * Created by zyn on 2017/8/02.
 */
@Mapper
public interface FriendDao {
    String TABLE_NAME = " friend ";
    String INSERT_FIELDS = " cared_user_id, has_cared ";
    String SELECT_FIELDS = " user_id," + INSERT_FIELDS;

    /**
     * @param userId
     * @param caredUserId
     */
    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS, ") ", "values(#{userId}, #{caredUserId})"})
    void insertFriend(int userId, int caredUserId);

    /**
     * @param userId
     * @param caredUserId
     * @return
     */
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where user_id=#{userId} and cared_user_id=#{caredUserId}"})
    Friend selectFriendByUserIdAndCaredId(int userId, int caredUserId);

    /**
     * @param userId
     * @param caredUserId
     * @return
     */
    @Select({"select has_cared from", TABLE_NAME, "where user_id=#{userId} and cared_user_id=#{caredUserId}"})
    int selectStatusForUserAndCaredUser(int userId, int caredUserId);

    /**
     * @param userId
     * @return
     */
    //TODO: 查询用户所有的粉丝，连接查询。
    @Select({""})
    List<User> selectUserFansByUserId(int userId);

    /**
     * @param userId
     * @param cardUserId
     */
    @Delete({"delete from ", TABLE_NAME, "where user_id=#{userId} and cared_user_id=#{caredUserId0}"})
    void deleteUserFanCaredUserId(int userId, int cardUserId);
}