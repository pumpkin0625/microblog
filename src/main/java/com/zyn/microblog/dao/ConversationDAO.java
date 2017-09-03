package com.zyn.microblog.dao;

import com.zyn.microblog.usercenter.model.Conversation;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zyn on 2017/8/7.
 */
@Mapper
public interface ConversationDAO {
    String TABLE_NAME = " conversation";
    String INSERT_FIELDS = " from_user_id, to_user_id, type, created_date, delete_mark";
    String SELECT_FIELDS = " conversation_id," + INSERT_FIELDS;

    /**
     * 插入conversation
     *
     * @param conversation conversation，不用填写conversationId，插入后自动填充。
     */
    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS,
            ") values(#{fromUserId}, #{toUserId}, #{type}, #{createdDate}, #{deleteMark})"})
    @Options(keyProperty = "conversationId", useGeneratedKeys = true)
    void insertCvst(Conversation conversation);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME,
            "where from_user_id=#{fromUserId} and delete_mark != 1 limit #{offset}, #{limit}"})
    @Results(id = "conversation", value = {
            @Result(id = true, property = "conversationId", column = "conversation_id"),
            @Result(property = "fromUserId", column = "from_user_id"),
            @Result(property = "toUserId", column = "to_user_id"),
            @Result(property = "type", column = "type"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "deleteMark", column = "delete_mark")
    })
    List<Conversation> selectCvstByFromUserId(@Param("fromUserId") int fromUserId,
                                              @Param("offset") int offset,
                                              @Param("limit") int limit);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where conversation_id=#{cvstId} and delete_mark != 1 "})
    @ResultMap("conversation")
    Conversation selectCvstByCvstId(int cvstId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME,
            "where to_user_id=#{toUserId} and delete_mark != 1 limit #{offset}, #{limit}"})
    @ResultMap("conversation")
    List<Conversation> selectCvstByToUserId(@Param("toUserId") int toUserId,
                                            @Param("offset") int offset,
                                            @Param("limit") int limit);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME,
            "where from_user_id=#{fromToUserId} and to_user_id=#{fromToUserId} and delete_mark != 1 limit #{offset}, #{limit}"})
    @ResultMap("conversation")
    List<Conversation> selectCvstByFromToUserId(@Param("fromToUserId") int fromToUserId,
                                                @Param("offset") int offset,
                                                @Param("limit") int limit);

    @Delete({"delete from", TABLE_NAME, "where conversation_id=#{cvstId}"})
    void deleteCvstByCvstId(int cvstId);
}
