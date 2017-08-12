package com.zyn.microblog.model;

import lombok.*;

import java.util.Date;

/**
 * Created by zyn on 2017/7/26.
 */
@Setter
@Getter
@ToString
public class Message {
    private int messageId;          //消息id
    private int senderId;           //发送方
    private int receiverId;         //接收方
    private Date createdDate;       //创建时间
    private String content;         //内容
    private int has_read;           //是否已读
    private Integer conversationId; //所属的会话id
}
