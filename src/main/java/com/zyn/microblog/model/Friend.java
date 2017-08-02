package com.zyn.microblog.model;

/**
 * Created by zyn on 2017/7/26.
 */
public class Friend {
    private Integer userId;
    private Integer caredUserId;
    private Integer hasCared;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCaredUserId() {
        return caredUserId;
    }

    public void setCaredUserId(Integer caredUserId) {
        this.caredUserId = caredUserId;
    }

    public Integer getHasCared() {
        return hasCared;
    }

    public void setHasCared(Integer hasCared) {
        this.hasCared = hasCared;
    }


}
