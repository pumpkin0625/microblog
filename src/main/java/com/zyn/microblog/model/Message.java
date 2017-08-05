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
    private int messageId;
    private int senderId;
    private int receiverId;
    private Date createdDate;
    private String content;
    private int has_read;
    private String conversationId;
}
