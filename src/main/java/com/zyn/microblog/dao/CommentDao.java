package com.zyn.microblog.dao;

import com.zyn.microblog.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zyn on 2017/8/01.
 * TODO: 应该给comment再加一个字段，如reply_id，是一个外键，引用comment_id，说明它是给哪个评论的评论，参考微信中的评论视图。
 */
@Component
@Mapper
public interface CommentDao {


    /**
     * 添加评论，评论不用设置，添加成功后id自动填充。
     *
     * @param comment 评论实体
     */
    void addComment(Comment comment);

    /**
     * 查询指定commentId的评论
     *
     * @param commentId 指定的评论id
     */
    void deleteCommentByCommentId(int commentId);

    /**
     * 查询指定微博的所有评论。
     *
     * @param microblogId 微博id
     * @return 评论列表，按照评论时间降序排列。
     */
    List<Comment> selectCommentByMicroblogId(int microblogId);
}
