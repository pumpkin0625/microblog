package com.zyn.microblog.usercenter.model;

import lombok.*;

import java.util.Date;

/**
 * 微博评论
 * Created by zyn on 2017/7/26.
 */
@Setter
@Getter
@ToString
public class Comment {
    private int commentId;      //评论id
    private int userId;         //评论用户id
    private int microblogId;    //所评论的微博id
    private int entityId;       // ？
    private int entityType;     // ？
    private Date createdDate;   //评论创建的时间
    private String content;     //评论正文
    private int status;         //评论状态，0表示给微博的评论，1表示给某条评论的评论
}
