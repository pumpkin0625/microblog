package com.zyn.microblog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by zyn on 2017/7/26.
 */
@Setter
@Getter
@ToString
public class Microblog {
    private int microblogId;    //微博id¬
    private int userId;         //发表者id
    private Date createdDate;   //发表时间
    private String content;     //内容
    private int likeCount;      //点赞数
    private int commentCount;   //评论数
}
