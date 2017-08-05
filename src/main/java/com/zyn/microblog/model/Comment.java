package com.zyn.microblog.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * Created by zyn on 2017/7/26.
 */
@Setter
@Getter
@ToString
public class Comment {
    private int commentId;
    private int userId;
    private int microblogId;
    private int entityId;
    private int entityType;
    private Date createdDate;
    private String content;
    private int status;
}
