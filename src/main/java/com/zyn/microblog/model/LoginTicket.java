package com.zyn.microblog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by zyn on 2017/7/26.
 */
@Getter
@Setter
@ToString
public class LoginTicket {
    private int loginTicketId;
    private int userId;
    private String ticket;
    private Date expired;
    private int status;
}
