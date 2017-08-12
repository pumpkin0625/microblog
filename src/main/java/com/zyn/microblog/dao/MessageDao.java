package com.zyn.microblog.dao;

import com.zyn.microblog.model.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zyn on 2017/8/12.
 */
@Mapper
public interface MessageDao {
    String TABLE_NAME = " message";
    String INSERT_FIELDS = " sender_id, receiver_id, created_date, content, has_read, conversation_id ";
    String SELECT_FIELDS = " message_id," + INSERT_FIELDS;

    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{senderId}, #{receiverId}, #{createdDate}, #{content}, #{hasRead}, #{conversationId})"})
    void insertMessage(Message message);

    /**
     * 根据
     *
     * @param messageId
     * @return
     */
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where message_id=#{messageId}"})
    @Results(id = "message", value = {
            @Result(id = true, property = "messageId", column = "message_id"),
            @Result(property = "senderId", column = "sender_id"),
            @Result(property = "receiverId", column = "receiver_id"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "content", column = "content"),
            @Result(property = "hasRead", column = "has_read"),
            @Result(property = "conversationId", column = "conversation_id")
    })
    Message selectMessageByMessageId(int messageId);

    /**
     * 根据查询会话id所属的最新的n条消息
     *
     * @param conversationId 所属的会话id
     * @param offset         偏移量
     * @param limit          查询结果条数
     * @return 最新的limit条message列表
     */
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME,
            "where conversation_id=#{conversationId} limit #{offset}, #{limit}"})
    @ResultMap("message")
    List<Message> selectMesagesByConversationId(@Param("conversationId") int conversationId,
                                                @Param("offset") int offset,
                                                @Param("limit") int limit);
}