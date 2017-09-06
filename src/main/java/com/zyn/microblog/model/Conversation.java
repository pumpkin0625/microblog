package com.zyn.microblog.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 私信中的会话
 * Created by zyn on 2017/8/7.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"createdDate"})
public class Conversation {
    private Integer conversationId; //会话id
    private Integer fromUserId;     //发送方
    private Integer toUserId;       //接收方
    private Integer type;           //type有可能为0:一对一会话，和1:多对一会话，多对一会话只在toUserId端显示
    private Date createdDate;       //创建时间
    private Integer deleteMark;         //1表示已删除，2表示未删除
}
