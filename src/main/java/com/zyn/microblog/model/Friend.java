package com.zyn.microblog.model;

/**
 * Created by zyn on 2017/7/26.
 */
public class Friend {
    private int userId;
    private int caredUserId;
    private int hasCared;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCaredUserId() {
        return caredUserId;
    }

    public void setCaredUserId(int caredUserId) {
        this.caredUserId = caredUserId;
    }

    public int getHasCared() {
        return hasCared;
    }

    public void setHasCared(int hasCared) {
        this.hasCared = hasCared;
    }


}
