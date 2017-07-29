package com.zyn.microblog.model;

import java.util.Date;

/**
 * Created by zyn on 2017/7/26.
 */
public class Microblog {
    private int microblogId;
    private int userId;
    private Date createdDate;
    private String content;
    private int likeCount;
    private int commentCount;

    public int getMicroblogId() {
        return microblogId;
    }

    public void setMicroblogId(int microblogId) {
        this.microblogId = microblogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }



}
