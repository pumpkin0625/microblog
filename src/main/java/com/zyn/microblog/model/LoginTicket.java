package com.zyn.microblog.model;

import java.util.Date;

/**
 * Created by zyn on 2017/7/26.
 */
public class LoginTicket {
    private int loginTicketId;
    private int userId;
    private String ticket;
    private Date expired;
    private int status;

    public int getLoginTicketId() {
        return loginTicketId;
    }

    public void setLoginTicketId(int loginTicketId) {
        this.loginTicketId = loginTicketId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
