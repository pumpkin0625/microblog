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
public class User {
    private Integer userId;
    private String userName;
    private String nickname;
    private String realName;
    private String password;
    private String salt;
    private String headUrl;
    private String sex;
    private String email;
    private String phone;
    private String address;
    private Date birthday;
    private String introduction;
}
