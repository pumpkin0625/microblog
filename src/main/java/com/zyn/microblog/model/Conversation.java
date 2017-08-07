package com.zyn.microblog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by zyn on 2017/8/7.
 */
@Getter
@Setter
@ToString
public class Conversation {
    private Integer conversationId;
    private Integer fromUserId;
    private Integer toUserId;
    private Integer type;   //type有可能为一对一会话，和多对一会话，多对一会话只在toUserId端显示
    private Date createdDate;
}
