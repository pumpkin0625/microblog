package com.zyn.microblog.dao;

import com.zyn.microblog.usercenter.model.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zyn on 2017/8/01.
 * TODO: 应该给comment再加一个字段，如reply_id，是一个外键，引用comment_id，说明它是给哪个评论的评论，参考微信中的评论视图。
 */
@Component
@Mapper
public interface CommentDao {

    String TABLE_NAME = " comment ";
    String INSERT_FIELDS = " user_id, microblog_id, entity_id, entity_type, created_date, content, status ";
    String SELECT_FIELDS = " microblog_id," + INSERT_FIELDS;

    /**
     * 添加评论，评论不用设置，添加成功后id自动填充。
     *
     * @param comment 评论实体
     */
    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS, ") values(#{userId}, #{microblogId}, #{entityId}, #{entityType}, #{createdDate}, #{content}, #{status})"})
    @Options(keyProperty = "commentId", useGeneratedKeys = true)
    void addComment(Comment comment);

    /**
     * 查询指定commentId的评论
     *
     * @param commentId 指定的评论id
     */
    @Select({"select", SELECT_FIELDS, " from ", TABLE_NAME, "where comment_id=#{commentId} and status=0"})
    @Results(id = "comment", value = {
            @Result(id = true, property = "commentId", column = "comment_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "microblogId", column = "microblog_id"),
            @Result(property = "entityId", column = "entity_id"),
            @Result(property = "entityType", column = "entity_type"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "content", column = "content"),
            @Result(property = "status", column = "status")
    })
    Comment selectCommentByCommentId(int commentId);

    /**
     * 查询指定微博的所有评论。
     *
     * @param microblogId 微博id
     * @return 评论列表，按照评论时间降序排列。
     */
    @Select({"select", SELECT_FIELDS, " from ", TABLE_NAME, "where microblog_id = #{microblogId} and status=0"})
    @ResultMap("comment")
    List<Comment> selectCommentByMicroblogId(int microblogId);

    /**
     * 删除指定微博的所有comment
     *
     * @param microblogId
     */
    @Update({"update", TABLE_NAME, " set status = 1 where microblog_id=#{microblogId}"})
    void deleteCommentsByMicroblogId(int microblogId);

    /**
     * 根据commentId删除comment
     * @param commentId
     */
    @Update({"update", TABLE_NAME, " set status = 1 where comment_id=#{microblogId}"})
    void deleteCommentByCommentId(int commentId);
}
